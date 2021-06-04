package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetTrackerDto;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetTrackerMapper;
import al.ikubinfo.healthometer.activity.repository.TargetTrackerRepository;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetTrackerCriteria;
import al.ikubinfo.healthometer.activity.repository.specification.TargetTrackerSpecificationBuilder;
import al.ikubinfo.healthometer.exception.NotAuthorizedEx;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.enums.Role;
import al.ikubinfo.healthometer.users.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TargetTrackerService extends ServiceTemplate<
        TargetTrackerEntity,
        TargetTrackerDto,
        TargetTrackerMapper,
        TargetTrackerRepository,
        TargetTrackerCriteria,
        TargetTrackerSpecificationBuilder> {

    private UserRepository userRepository;
    private TargetService targetService;

    public TargetTrackerService(TargetTrackerRepository repository, TargetTrackerMapper mapper, TargetTrackerSpecificationBuilder specificationBuilder,
                                UserRepository userRepository, TargetService targetService) {
        super(repository, mapper, specificationBuilder);
        this.userRepository = userRepository;
        this.targetService = targetService;
    }

    @Override
    public Page<?> filter(TargetTrackerCriteria criteria) {
        UserEntity loggedUser = userRepository.findByUsername(SecurityUtils.getCurrentUsername().get());
        if (!loggedUser.getRole().getName().equals(Role.ADMIN)) {
            if (criteria.getUserTargetCategoryId() == null) {
                throw new NotAuthorizedEx("Please contact the administrator!");
            }
            TargetEntity targetEntity = targetService.getEntity(criteria.getUserTargetCategoryId());
            if (targetEntity == null || loggedUser.getId().equals(targetEntity.getUserEntity().getId())) {
                throw new NotAuthorizedEx("You are not authorized for this action! ");
            }
        }
        return super.filter(criteria);
    }
}
