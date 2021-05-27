package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.AbstractController;
import al.ikubinfo.healthometer.activity.dto.BmiDto;
import al.ikubinfo.healthometer.activity.dto.BodyMeasurementCategoryDto;
import al.ikubinfo.healthometer.activity.dto.UserBodyMeasurementDto;
import al.ikubinfo.healthometer.activity.service.BodyMeasurementCategoryService;
import al.ikubinfo.healthometer.activity.service.UserBodyMeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bodyMeasurement")
public class UserBodyMeasurementController extends AbstractController<UserBodyMeasurementDto,
        UserBodyMeasurementService> {
    public UserBodyMeasurementController(UserBodyMeasurementService service) {
        super(service);
    }

    @GetMapping("/calculateBmi")
    public ResponseEntity<BmiDto> calculateBmi(@PathVariable @NonNull Long id) {
        return new ResponseEntity<>(service.calculateBmi(), HttpStatus.OK);
    }
}
