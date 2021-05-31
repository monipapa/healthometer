package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.dto.BmiDto;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.activity.mappers.MeasurementMapper;
import al.ikubinfo.healthometer.activity.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

@Service

public class MeasurementService extends ServiceTemplate<
        MeasurementEntity,
        MeasurementDto,
        MeasurementMapper,
        MeasurementRepository> {
    public MeasurementService(MeasurementRepository repository, MeasurementMapper mapper) {
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
