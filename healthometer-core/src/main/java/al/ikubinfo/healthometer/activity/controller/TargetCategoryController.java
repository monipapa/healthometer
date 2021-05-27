package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.AbstractController;
import al.ikubinfo.healthometer.activity.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.activity.service.TargetCategoryService;

public class TargetCategoryController extends AbstractController<TargetCategoryDto,
        TargetCategoryService> {
    public TargetCategoryController(TargetCategoryService service) {
        super(service);
    }
}
