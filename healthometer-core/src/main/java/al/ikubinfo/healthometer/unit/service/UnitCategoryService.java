package al.ikubinfo.healthometer.unit.service;

import al.ikubinfo.commons.exception.WarningEx;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.unit.mappers.UnitCategoryMapper;
import al.ikubinfo.healthometer.unit.repository.UnitCategoryRepository;
import al.ikubinfo.healthometer.unit.repository.UnitSubcategoryRepository;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitCategoryCriteria;
import al.ikubinfo.healthometer.unit.repository.specification.UnitCategorySpecificationBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitCategoryService
        extends ServiceTemplate<
        UnitCategoryEntity,
        UnitCategoryDto,
        UnitCategoryMapper,
        UnitCategoryRepository,
        UnitCategoryCriteria,
        UnitCategorySpecificationBuilder> {

  public UnitSubcategoryRepository unitSubcategoryRepository;

  public UnitCategoryService(
          UnitCategoryRepository repository,
          UnitCategoryMapper mapper,
          UnitCategorySpecificationBuilder specificationBuilder,
          UnitSubcategoryRepository unitSubcategoryRepository) {
    super(repository, mapper, specificationBuilder);
    this.unitSubcategoryRepository = unitSubcategoryRepository;
  }

  @Override
  public void doDelete(UnitCategoryEntity entity) {
    List<UnitSubcategoryEntity> subcategoryDtoList = unitSubcategoryRepository.findByUnitCategoryEntity(entity);
    if (subcategoryDtoList.size() != 0) {
      throw new WarningEx("There are unit subcategories for this category! Delete them first! ");
    }
    super.doDelete(entity);
  }
}
