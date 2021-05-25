package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.BodyMeasurementCategoryDto;
import al.ikubinfo.healthometer.activity.entity.BodyMeasurementCategoryEntity;
import al.ikubinfo.healthometer.activity.mappers.BodyMeasurementCategoryMapper;
import al.ikubinfo.healthometer.activity.repository.BodyMeasurementCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BodyMeasurementCategoryService
    extends AbstractService<
        BodyMeasurementCategoryEntity,
        BodyMeasurementCategoryDto,
        BodyMeasurementCategoryMapper,
        BodyMeasurementCategoryRepository> {

  public BodyMeasurementCategoryService(
      BodyMeasurementCategoryRepository repository, BodyMeasurementCategoryMapper mapper) {
    super(repository, mapper);
  }
}
