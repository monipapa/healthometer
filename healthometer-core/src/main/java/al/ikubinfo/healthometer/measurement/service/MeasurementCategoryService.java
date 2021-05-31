package al.ikubinfo.healthometer.measurement.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import al.ikubinfo.healthometer.measurement.mappers.MeasurementCategoryMapper;
import al.ikubinfo.healthometer.measurement.repository.MeasurementCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class MeasurementCategoryService
    extends ServiceTemplate<
        MeasurementCategoryEntity,
        MeasurementCategoryDto,
        MeasurementCategoryMapper,
        MeasurementCategoryRepository> {

  public MeasurementCategoryService(
          MeasurementCategoryRepository repository, MeasurementCategoryMapper mapper) {
    super(repository, mapper);
  }
}
