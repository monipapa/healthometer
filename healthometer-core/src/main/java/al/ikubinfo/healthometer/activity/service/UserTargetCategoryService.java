package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.UserTargetCategoryDto;
import al.ikubinfo.healthometer.activity.entity.UserTargetCategoryEntity;
import al.ikubinfo.healthometer.activity.mappers.UserTargetCategoryMapper;
import al.ikubinfo.healthometer.activity.repository.UserTargetCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTargetCategoryService extends AbstractService<
        UserTargetCategoryEntity,
        UserTargetCategoryDto,
        UserTargetCategoryMapper,
        UserTargetCategoryRepository> {
    public UserTargetCategoryService(UserTargetCategoryRepository repository, UserTargetCategoryMapper mapper) {
        super(repository, mapper);
    }
}
