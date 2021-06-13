package al.ikubinfo.healthometer.unit.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.unit.mappers.UnitCategoryMapper;
import al.ikubinfo.healthometer.unit.repository.UnitCategoryRepository;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitCategoryCriteria;
import al.ikubinfo.healthometer.unit.repository.specification.UnitCategorySpecificationBuilder;
import org.springframework.stereotype.Service;

@Service
public class UnitCategoryService
        extends ServiceTemplate<
        UnitCategoryEntity,
        UnitCategoryDto,
        UnitCategoryMapper,
        UnitCategoryRepository,
        UnitCategoryCriteria,
        UnitCategorySpecificationBuilder> {

  public UnitCategoryService(
          UnitCategoryRepository repository,
          UnitCategoryMapper mapper,
          UnitCategorySpecificationBuilder specificationBuilder) {
    super(repository, mapper, specificationBuilder);
  }
}
