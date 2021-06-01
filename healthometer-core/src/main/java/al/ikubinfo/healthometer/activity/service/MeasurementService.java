package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.exception.WarningEx;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.BmiDto;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.activity.mappers.MeasurementMapper;
import al.ikubinfo.healthometer.activity.repository.MeasurementRepository;
import al.ikubinfo.healthometer.activity.repository.criteria.MeasurementCriteria;
import al.ikubinfo.healthometer.activity.repository.specification.MeasurementSpecificationBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MeasurementService extends ServiceTemplate<
        MeasurementEntity,
        MeasurementDto,
        MeasurementMapper,
        MeasurementRepository> {
    public MeasurementService(MeasurementRepository repository, MeasurementMapper mapper, MeasurementSpecificationBuilder specificationBuilder, MeasurementSpecificationBuilder specificationBuilder1) {
        super(repository, mapper);
        this.specificationBuilder = specificationBuilder1;
    }

    protected final MeasurementSpecificationBuilder specificationBuilder;

    public MeasurementEntity getLastMeasurementPerUserPerCategory(Long userId, Long measurementCategoryId) {
        MeasurementCriteria criteria = new MeasurementCriteria();
        criteria.setPageSize(1);
        criteria.setUserId(userId);
        criteria.setBodyMeasurementCategoryId(measurementCategoryId);
        criteria.setSortDirection(Sort.Direction.DESC.name());
        List<MeasurementEntity> measurementEntities = repository.findAll(specificationBuilder.filter(criteria));
        if (measurementEntities.size() == 0) {
            throw new WarningEx("There is no such category measured from this user!");
        } else {
            return measurementEntities.get(0);
        }
    }

}
