package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.activity.dto.TargetTrackerDto;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetTrackerCriteria;
import al.ikubinfo.healthometer.activity.service.TargetTrackerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("targetTrackers")
public class TargetTrackerController extends ControllerTemplate<TargetTrackerDto, TargetTrackerCriteria, TargetTrackerService> {
    public TargetTrackerController(TargetTrackerService service) {
        super(service);
    }
}
