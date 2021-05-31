package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetTrackerDto;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetTrackerMapper;
import al.ikubinfo.healthometer.activity.repository.TargetTrackerRepository;
import org.springframework.stereotype.Service;

@Service
public class TargetTrackerService extends ServiceTemplate<
        TargetTrackerEntity,
        TargetTrackerDto,
        TargetTrackerMapper,
        TargetTrackerRepository> {
    public TargetTrackerService(TargetTrackerRepository repository, TargetTrackerMapper mapper) {
        super(repository, mapper);
    }
}
