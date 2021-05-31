package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.activity.dto.BmiDto;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
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
public class MeasurementController extends ControllerTemplate<MeasurementDto,
        MeasurementService> {
    public MeasurementController(MeasurementService service) {
        super(service);
    }

    @GetMapping("/calculateBmi")
    public ResponseEntity<BmiDto> calculateBmi(@PathVariable @NonNull Long id) {
        return new ResponseEntity<>(service.calculateBmi(), HttpStatus.OK);
    }
}
