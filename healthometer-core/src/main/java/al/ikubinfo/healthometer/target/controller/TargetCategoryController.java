package al.ikubinfo.healthometer.target.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.target.repository.criteria.TargetCategoryCriteria;
import al.ikubinfo.healthometer.target.service.TargetCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("targetCategories")
public class TargetCategoryController
        extends ControllerTemplate<TargetCategoryDto, TargetCategoryCriteria, TargetCategoryService> {
  public TargetCategoryController(TargetCategoryService service) {
    super(service);
  }
}
