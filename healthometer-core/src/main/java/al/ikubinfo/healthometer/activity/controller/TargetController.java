package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetDto;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetCriteria;
import al.ikubinfo.healthometer.activity.service.TargetService;
import al.ikubinfo.healthometer.exception.NotImplementedEx;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("targets")
public class TargetController extends ControllerTemplate<TargetDto, TargetCriteria, TargetService> {
    public TargetController(TargetService service) {
        super(service);
    }

}
