package al.ikubinfo.healthometer.measurement.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import al.ikubinfo.healthometer.measurement.mappers.MeasurementCategoryMapper;
import al.ikubinfo.healthometer.measurement.repository.MeasurementCategoryRepository;
import al.ikubinfo.healthometer.measurement.repository.criteria.MeasurementCategoryCriteria;
import al.ikubinfo.healthometer.measurement.repository.specification.MeasurementCategorySpecificationBuilder;
import org.springframework.stereotype.Service;

@Service
public class MeasurementCategoryService
        extends ServiceTemplate<MeasurementCategoryEntity,
        MeasurementCategoryDto,
        MeasurementCategoryMapper,
        MeasurementCategoryRepository,
        MeasurementCategoryCriteria,
        MeasurementCategorySpecificationBuilder> {
    public MeasurementCategoryService(MeasurementCategoryRepository repository, MeasurementCategoryMapper mapper, MeasurementCategorySpecificationBuilder specificationBuilder) {
        super(repository, mapper, specificationBuilder);
    }
}
