package al.ikubinfo.healthometer.target.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.target.entity.TargetCategoryEntity;
import al.ikubinfo.healthometer.target.mappers.TargetCategoryMapper;
import al.ikubinfo.healthometer.target.repository.TargetCategoryRepository;
import al.ikubinfo.healthometer.target.repository.criteria.TargetCategoryCriteria;
import al.ikubinfo.healthometer.target.repository.specification.TargetCategorySpecificationBuilder;
import org.springframework.stereotype.Service;

@Service
public class TargetCategoryService extends ServiceTemplate<TargetCategoryEntity,
        TargetCategoryDto,
        TargetCategoryMapper,
        TargetCategoryRepository,
        TargetCategoryCriteria,
        TargetCategorySpecificationBuilder> {

    public TargetCategoryService(TargetCategoryRepository repository, TargetCategoryMapper mapper, TargetCategorySpecificationBuilder specificationBuilder) {
        super(repository, mapper, specificationBuilder);
    }
}
