package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.commons.security.SecurityUtils;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import al.ikubinfo.healthometer.activity.repository.criteria.MeasurementCriteria;
import al.ikubinfo.healthometer.activity.service.MeasurementService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bodyMeasurements")
public class MeasurementController extends ControllerTemplate<MeasurementDto, MeasurementCriteria, MeasurementService> {
    public MeasurementController(MeasurementService service) {
        super(service);
    }

}
