package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.AbstractController;
import al.ikubinfo.healthometer.activity.dto.UserTargetTrackerDto;
import al.ikubinfo.healthometer.activity.service.UserTargetTrackerService;

public class UserTargetTrackerController extends AbstractController<UserTargetTrackerDto,
        UserTargetTrackerService> {
    public UserTargetTrackerController(UserTargetTrackerService service) {
        super(service);
    }
}
