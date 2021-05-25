package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.activity.entity.TargetCategoryEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetCategoryMapper;
import al.ikubinfo.healthometer.activity.repository.TargetCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class TargetCategoryService extends AbstractService<
        TargetCategoryEntity,
        TargetCategoryDto,
        TargetCategoryMapper,
        TargetCategoryRepository> {
    public TargetCategoryService(TargetCategoryRepository repository, TargetCategoryMapper mapper) {
        super(repository, mapper);
    }
}
