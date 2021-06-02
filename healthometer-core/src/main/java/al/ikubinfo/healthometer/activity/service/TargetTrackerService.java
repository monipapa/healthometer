package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetTrackerDto;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetTrackerMapper;
import al.ikubinfo.healthometer.activity.repository.TargetTrackerRepository;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetTrackerCriteria;
import al.ikubinfo.healthometer.activity.repository.specification.TargetTrackerSpecificationBuilder;
import org.springframework.stereotype.Service;

@Service
public class TargetTrackerService extends ServiceTemplate<
        TargetTrackerEntity,
        TargetTrackerDto,
        TargetTrackerMapper,
        TargetTrackerRepository,
        TargetTrackerCriteria,
        TargetTrackerSpecificationBuilder> {

    public TargetTrackerService(TargetTrackerRepository repository, TargetTrackerMapper mapper, TargetTrackerSpecificationBuilder specificationBuilder) {
        super(repository, mapper, specificationBuilder);
    }
}
