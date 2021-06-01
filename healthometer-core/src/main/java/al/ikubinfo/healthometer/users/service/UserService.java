package al.ikubinfo.healthometer.users.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.activity.service.MeasurementService;
import al.ikubinfo.healthometer.measurement.service.MeasurementCategoryService;
import al.ikubinfo.healthometer.users.dto.PasswordDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.enums.Status;
import al.ikubinfo.healthometer.users.mappers.StatusBidirectionalMapper;
import al.ikubinfo.healthometer.users.mappers.UserBidirectionalMapper;
import al.ikubinfo.healthometer.users.repository.RoleRepository;
import al.ikubinfo.healthometer.users.repository.StatusRepository;
import al.ikubinfo.healthometer.users.repository.UserRepository;
import al.ikubinfo.healthometer.users.repository.criteria.UserCriteria;
import al.ikubinfo.healthometer.users.repository.specification.UserSpecificationBuilder;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements UserDetailsService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private StatusRepository statusRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  private UserBidirectionalMapper userBidirectionalMapper;
  private StatusBidirectionalMapper statusBidirectionalMapper;

  private MeasurementService measurementService;
  private MeasurementCategoryService measurementCategoryService;

  protected final UserSpecificationBuilder userSpecificationBuilder;

  @Transactional(readOnly = true)
  public UserDto getUserById(Long id) {
    if (!isLoggedInUser(id)) {
      throw new AccessDeniedException("Access denied");
    }
    return userBidirectionalMapper.toDto(getUser(id));
  }

  public UserDto createUser(UserDto userDto) {
    userDto.setStatusDto(
        statusBidirectionalMapper.toDto(statusRepository.findByName(Status.ACTIVE.getStatus())));
    userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    return userBidirectionalMapper.toDto(
        userRepository.save(userBidirectionalMapper.toEntity(userDto)));
  }

  public UserDto editUser(Long id, UserDto userDto) {
    val user = getUser(id);
    if (!authenticate(user, userDto.getPassword()) || !isLoggedInUser(id)) {
      throw new AccessDeniedException("Access denied");
    }
    user.setEmail(userDto.getEmail());

    return userBidirectionalMapper.toDto(userRepository.save(user));
  }

  public void deleteUser(Long id) {
    val user = getUser(id);
    user.setStatus(statusRepository.findByName(Status.DELETED.getStatus()));
    userRepository.save(user);
  }

  public UserDto changePassword(Long id, PasswordDto passwordDto) {
    val user = getUser(id);
    if (!authenticate(user, passwordDto.getCurrentPassword()) || !isLoggedInUser(id)) {
      throw new AccessDeniedException("Access denied. Cannot change password");
    }
    user.setPassword(bCryptPasswordEncoder.encode(passwordDto.getNewPassword()));
    return userBidirectionalMapper.toDto(userRepository.save(user));
  }

  public UserDto changeRole(Long id, String newRole) {
    val user = getUser(id);
    user.setRole(roleRepository.findByName(newRole));
    return userBidirectionalMapper.toDto(userRepository.save(user));
  }

  private boolean authenticate(UserEntity user, String password) {
    return bCryptPasswordEncoder.matches(password, user.getPassword());
  }

  private boolean isLoggedInUser(Long id) {
    val user = userRepository.findByUsername(SecurityUtils.getCurrentUsername().get());
    if (user == null) return false;
    return id.equals(user.getId());
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) {
    val user = userRepository.findByUsername(username);
    List<GrantedAuthority> role =
            Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName()));
    return new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), role);
  }

  private UserEntity getUser(Long id) {
    return userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Invalid user with id: " + id));
  }

  public Page<?> filter(@Nullable UserCriteria criteria) {
    return getEntities(criteria).map(userBidirectionalMapper::toDto);
  }

  protected Page<UserEntity> getEntities(@Nullable UserCriteria criteria) {
    Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPageSize(),
            Sort.Direction.valueOf(criteria.getSortDirection()), criteria.getOrderBy());

    return (criteria != null)
            ? userRepository.findAll(userSpecificationBuilder.filter(criteria), pageable)
            : userRepository.findAll(pageable);

  }

  //TODO Query get last measurements
  //BMI = kg/m2
  @Transactional
  public MeasurementDto calculateBmi(Long userId) {
    //TODO static final fields
    MeasurementEntity height = measurementService.getLastMeasurementPerUserPerCategory(userId, 3l);
    MeasurementEntity weight = measurementService.getLastMeasurementPerUserPerCategory(userId, 1l);
    MeasurementDto dto = new MeasurementDto();
    dto.setUserDto(userBidirectionalMapper.toDto(userRepository.getOne(userId)));
    dto.setBodyMeasurementCategoryDto(measurementCategoryService.getSingle(3l));
    dto.setValue(height.getValue().divide((weight.getValue().multiply(weight.getValue())), 2, RoundingMode.UP));
    measurementService.save(dto);
    return dto;
  }
}
