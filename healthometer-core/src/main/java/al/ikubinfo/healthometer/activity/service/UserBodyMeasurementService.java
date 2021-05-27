package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.BmiDto;
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

    public BmiDto calculateBmi() {
        BmiDto bmi = new BmiDto();
        //TODO Query get last height measurement
        //Query get last weight measurement
        //BMI = kg/m2
        return bmi;
    }

}
