package al.ikubinfo.healthometer.unit.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitCategoryCriteria;
import al.ikubinfo.healthometer.unit.service.UnitCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unitCategories")
public class UnitCategoryController
        extends ControllerTemplate<UnitCategoryDto, UnitCategoryCriteria, UnitCategoryService> {

  public UnitCategoryController(UnitCategoryService unitCategoryService) {
    super(unitCategoryService);
  }
}
