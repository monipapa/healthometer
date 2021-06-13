package al.ikubinfo.healthometer.unit.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.unit.mappers.UnitSubcategoryMapper;
import al.ikubinfo.healthometer.unit.repository.UnitSubcategoryRepository;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitSubcategoryCriteria;
import al.ikubinfo.healthometer.unit.repository.specification.UnitSubcategorySpecificationBuilder;
import org.springframework.stereotype.Service;

@Service
public class UnitSubcategoryService
        extends ServiceTemplate<
        UnitSubcategoryEntity,
        UnitSubcategoryDto,
        UnitSubcategoryMapper,
        UnitSubcategoryRepository,
        UnitSubcategoryCriteria,
        UnitSubcategorySpecificationBuilder> {
    public UnitSubcategoryService(
            UnitSubcategoryRepository repository,
            UnitSubcategoryMapper mapper,
            UnitSubcategorySpecificationBuilder specificationBuilder) {
        super(repository, mapper, specificationBuilder);
    }
}
