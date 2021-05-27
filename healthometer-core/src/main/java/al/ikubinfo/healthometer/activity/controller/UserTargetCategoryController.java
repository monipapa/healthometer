package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.AbstractController;
import al.ikubinfo.healthometer.activity.dto.UserTargetCategoryDto;
import al.ikubinfo.healthometer.activity.service.UserTargetCategoryService;

public class UserTargetCategoryController extends AbstractController<UserTargetCategoryDto,
        UserTargetCategoryService> {
    public UserTargetCategoryController(UserTargetCategoryService service) {
        super(service);
    }
}
