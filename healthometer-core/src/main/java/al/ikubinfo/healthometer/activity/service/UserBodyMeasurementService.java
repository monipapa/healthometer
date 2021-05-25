package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.UserBodyMeasurementDto;
import al.ikubinfo.healthometer.activity.entity.UserBodyMeasurementEntity;
import al.ikubinfo.healthometer.activity.mappers.UserBodyMeasurementMapper;
import al.ikubinfo.healthometer.activity.repository.UserBodyMeasurementRepository;
import org.springframework.stereotype.Service;

@Service
public class UserBodyMeasurementService extends AbstractService<
        UserBodyMeasurementEntity,
        UserBodyMeasurementDto,
        UserBodyMeasurementMapper,
        UserBodyMeasurementRepository> {
    public UserBodyMeasurementService(UserBodyMeasurementRepository repository, UserBodyMeasurementMapper mapper) {
        super(repository, mapper);
    }
}
