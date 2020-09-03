package al.ikubinfo.healthometer.users.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.healthometer.users.dto.PasswordDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.enums.Status;
import al.ikubinfo.healthometer.users.mappers.StatusBidirectionalMapper;
import al.ikubinfo.healthometer.users.mappers.UserBidirectionalMapper;
import al.ikubinfo.healthometer.users.repository.RoleRepository;
import al.ikubinfo.healthometer.users.repository.StatusRepository;
import al.ikubinfo.healthometer.users.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  @Transactional(readOnly = true)
  public UserDto getUserById(Long id) {
    if (!isLoggedInUser(id)) {
      throw new AccessDeniedException("Access denied");
    }
    return userBidirectionalMapper.toDto(userRepository.findById(id).get());
  }

  public UserDto createUser(UserDto userDto) {
    userDto.setStatusDto(
        statusBidirectionalMapper.toDto(statusRepository.findByName(Status.ACTIVE.getStatus())));
    userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
    return userBidirectionalMapper.toDto(
        userRepository.save(userBidirectionalMapper.toEntity(userDto)));
  }

  public UserDto editUser(Long id, UserDto userDto) {
    UserEntity user = userRepository.getOne(id);
    if (!authenticate(user, userDto.getPassword()) || !isLoggedInUser(id)) {
      throw new AccessDeniedException("Access denied");
    }
    user.setEmail(userDto.getEmail());

    return userBidirectionalMapper.toDto(userRepository.save(user));
  }

  public void deleteUser(Long id) {
    UserEntity user = userRepository.getOne(id);
    user.setStatus(statusRepository.findByName(Status.DELETED.name()));
    userRepository.save(user);
  }

  public UserDto changePassword(Long id, PasswordDto passwordDto) {
    UserEntity user = userRepository.getOne(id);
    if (!authenticate(user, passwordDto.getCurrentPassword()) || !isLoggedInUser(id)) {
      throw new AccessDeniedException("Access denied. Cannot change password");
    }
    user.setPassword(bCryptPasswordEncoder.encode(passwordDto.getNewPassword()));
    return userBidirectionalMapper.toDto(userRepository.save(user));
  }

  public UserDto changeRole(Long id, String newRole) {
    UserEntity user = userRepository.getOne(id);
    user.setRole(roleRepository.findByName(newRole));
    return userBidirectionalMapper.toDto(userRepository.save(user));
  }

  private boolean authenticate(UserEntity user, String password) {
    return bCryptPasswordEncoder.matches(password, user.getPassword());
  }

  private boolean isLoggedInUser(Long id) {
    UserEntity user = userRepository.findByUsername(SecurityUtils.getCurrentUsername().get());
    return id.equals(user.getId());
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) {
    UserEntity user = userRepository.findByUsername(username);
    List<GrantedAuthority> role =
        Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName()));
    return new org.springframework.security.core.userdetails.User(
        user.getUsername(), user.getPassword(), role);
  }
}
