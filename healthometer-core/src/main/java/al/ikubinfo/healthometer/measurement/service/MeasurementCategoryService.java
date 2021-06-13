package al.ikubinfo.healthometer.measurement.service;

import al.ikubinfo.commons.exception.WarningEx;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.activity.repository.MeasurementRepository;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import al.ikubinfo.healthometer.measurement.mappers.MeasurementCategoryMapper;
import al.ikubinfo.healthometer.measurement.repository.MeasurementCategoryRepository;
import al.ikubinfo.healthometer.measurement.repository.criteria.MeasurementCategoryCriteria;
import al.ikubinfo.healthometer.measurement.repository.specification.MeasurementCategorySpecificationBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementCategoryService
        extends ServiceTemplate<
        MeasurementCategoryEntity,
        MeasurementCategoryDto,
        MeasurementCategoryMapper,
        MeasurementCategoryRepository,
        MeasurementCategoryCriteria,
        MeasurementCategorySpecificationBuilder> {
    public MeasurementRepository measurementRepository;

    public MeasurementCategoryService(
            MeasurementCategoryRepository repository,
            MeasurementCategoryMapper mapper,
            MeasurementCategorySpecificationBuilder specificationBuilder,
            MeasurementRepository measurementRepository) {
        super(repository, mapper, specificationBuilder);
        this.measurementRepository = measurementRepository;
    }

    @Override
    protected void doDelete(MeasurementCategoryEntity entity) {
        List<MeasurementEntity> measurementEntity = measurementRepository.findByBodyMeasurementCategoryEntity(entity);
        if (measurementEntity.size() != 0) {
            throw new WarningEx("There are measurement for this category!");
        }
        super.doDelete(entity);
    }
}
