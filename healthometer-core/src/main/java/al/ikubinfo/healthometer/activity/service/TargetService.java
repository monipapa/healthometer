package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetMapper;
import al.ikubinfo.healthometer.activity.repository.TargetRepository;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetCriteria;
import al.ikubinfo.healthometer.activity.repository.specification.TargetSpecificationBuilder;
import al.ikubinfo.healthometer.exception.NotAuthorizedEx;
import al.ikubinfo.healthometer.target.repository.TargetCategoryRepository;
import al.ikubinfo.healthometer.target.repository.criteria.TargetCategoryCriteria;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.enums.Role;
import al.ikubinfo.healthometer.users.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TargetService extends ServiceTemplate<
        TargetEntity,
        TargetDto,
        TargetMapper,
        TargetRepository,
        TargetCriteria,
        TargetSpecificationBuilder> {

    private UserRepository userRepository;

    public TargetService(TargetRepository repository, TargetMapper mapper, TargetSpecificationBuilder specificationBuilder, UserRepository userRepository) {
        super(repository, mapper, specificationBuilder);
        this.userRepository = userRepository;
    }

    @Override
    public Page<?> filter(TargetCriteria criteria) {
        UserEntity loggedUser = userRepository.findByUsername(SecurityUtils.getCurrentUsername().get());

        if (!loggedUser.getRole().getName().equals(Role.ADMIN)) {
            if (loggedUser == null || loggedUser.getId().equals(criteria.getUserId())) {
                throw new NotAuthorizedEx("You are not authorized for this action! ");
            }
        }
        return super.filter(criteria);
    }
}
