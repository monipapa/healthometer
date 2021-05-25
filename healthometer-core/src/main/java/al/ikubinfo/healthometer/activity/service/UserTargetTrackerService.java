package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.UserTargetTrackerDto;
import al.ikubinfo.healthometer.activity.entity.UserTargetTrackerEntity;
import al.ikubinfo.healthometer.activity.mappers.UserTargetTrackerMapper;
import al.ikubinfo.healthometer.activity.repository.UserTargetTrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTargetTrackerService extends AbstractService<
        UserTargetTrackerEntity,
        UserTargetTrackerDto,
        UserTargetTrackerMapper,
        UserTargetTrackerRepository> {
    public UserTargetTrackerService(UserTargetTrackerRepository repository, UserTargetTrackerMapper mapper) {
        super(repository, mapper);
    }
}
