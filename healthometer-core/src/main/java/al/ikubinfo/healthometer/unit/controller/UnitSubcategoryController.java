package al.ikubinfo.healthometer.unit.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.unit.service.UnitSubcategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unitSubategories")
public class UnitSubcategoryController extends ControllerTemplate<UnitSubcategoryDto, UnitSubcategoryService> {

  public UnitSubcategoryController(UnitSubcategoryService unitSubcategoryService) {
    super(unitSubcategoryService);
  }

}
