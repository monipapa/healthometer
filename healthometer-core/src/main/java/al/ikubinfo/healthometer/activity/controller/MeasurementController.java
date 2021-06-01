package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.activity.dto.BmiDto;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.repository.criteria.MeasurementCriteria;
import al.ikubinfo.healthometer.activity.service.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bodyMeasurement")
public class MeasurementController extends ControllerTemplate<MeasurementDto, MeasurementCriteria,
        MeasurementService> {
    public MeasurementController(MeasurementService service) {
        super(service);
    }

}
