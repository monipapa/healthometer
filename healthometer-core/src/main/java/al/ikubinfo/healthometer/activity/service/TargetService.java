package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetMapper;
import al.ikubinfo.healthometer.activity.repository.TargetRepository;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetCriteria;
import al.ikubinfo.healthometer.activity.repository.specification.TargetSpecificationBuilder;
import al.ikubinfo.commons.exception.NotAuthorizedEx;
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
    public void doGetSingle(TargetEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doGetSingle(entity);
    }

    @Override
    public void doSave(TargetEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doSave(entity);
    }

    @Override
    public void doUpdate(TargetEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doUpdate(entity);
    }

    @Override
    public void doDelete(TargetEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doDelete(entity);
    }

    @Override
    public Page<?> filter(TargetCriteria criteria) {
        checkIfLoggedUserIsAuthorized(criteria.getUserId());
        return super.filter(criteria);
    }

    public void checkIfLoggedUserIsAuthorized(Long userId) {
        UserEntity loggedUser = userRepository.findByUsername(SecurityUtils.getCurrentUsername().get());

        if (!loggedUser.getRole().getName().equals(Role.ADMIN.getRole())) {
            if (loggedUser == null || !loggedUser.getId().equals(userId)) {
                throw new NotAuthorizedEx("You are not authorized for this action! ");
            }
        }
    }
}
