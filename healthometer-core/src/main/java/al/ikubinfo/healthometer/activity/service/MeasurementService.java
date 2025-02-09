package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.activity.mappers.MeasurementMapper;
import al.ikubinfo.healthometer.activity.repository.MeasurementRepository;
import al.ikubinfo.healthometer.activity.repository.criteria.MeasurementCriteria;
import al.ikubinfo.healthometer.activity.repository.specification.MeasurementSpecificationBuilder;
import al.ikubinfo.commons.exception.NotAuthorizedEx;
import al.ikubinfo.commons.exception.WarningEx;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.enums.Role;
import al.ikubinfo.healthometer.users.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService extends ServiceTemplate<
        MeasurementEntity,
        MeasurementDto,
        MeasurementMapper,
        MeasurementRepository,
        MeasurementCriteria,
        MeasurementSpecificationBuilder> {

    protected final MeasurementSpecificationBuilder specificationBuilder;
    private UserRepository userRepository;

    public MeasurementService(MeasurementRepository repository, MeasurementMapper mapper, MeasurementSpecificationBuilder specificationBuilder,
                              MeasurementSpecificationBuilder specificationBuilder1, UserRepository userRepository) {
        super(repository, mapper, specificationBuilder);
        this.specificationBuilder = specificationBuilder1;
        this.userRepository = userRepository;
    }

    public MeasurementEntity getLastMeasurementPerUserPerCategory(Long userId, Long measurementCategoryId) {
        MeasurementCriteria criteria = new MeasurementCriteria();
        criteria.setPageSize(1);
        criteria.setUserId(userId);
        criteria.setBodyMeasurementCategoryId(measurementCategoryId);
        criteria.setSortDirection(Sort.Direction.DESC.name());
        List<MeasurementEntity> measurementEntities = repository.findAll(specificationBuilder.filter(criteria));
/*
        List<MeasurementEntity> measurementEntities = repository.findAll(super.specificationBuilder.filter(criteria));
*/

        if (measurementEntities.size() == 0) {
            throw new WarningEx("There is no such category measured from this user!");
        } else {
            return measurementEntities.get(0);
        }
    }

    @Override
    public void doGetSingle(MeasurementEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doGetSingle(entity);
    }

    @Override
    public void doSave(MeasurementEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doSave(entity);
    }

    @Override
    public void doUpdate(MeasurementEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doUpdate(entity);
    }

    @Override
    public void doDelete(MeasurementEntity entity) {
        checkIfLoggedUserIsAuthorized(entity.getUserEntity().getId());
        super.doDelete(entity);
    }

    @Override
    public Page<?> filter(MeasurementCriteria criteria) {
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
