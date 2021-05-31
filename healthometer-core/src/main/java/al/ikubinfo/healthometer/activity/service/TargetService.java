package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import al.ikubinfo.healthometer.activity.mappers.TargetMapper;
import al.ikubinfo.healthometer.activity.repository.TargetRepository;
import org.springframework.stereotype.Service;

@Service
public class TargetService extends ServiceTemplate<
        TargetEntity,
        TargetDto,
        TargetMapper,
        TargetRepository> {
    public TargetService(TargetRepository repository, TargetMapper mapper) {
        super(repository, mapper);
    }
}
