package al.ikubinfo.healthometer.unit.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitSubcategoryCriteria;
import al.ikubinfo.healthometer.unit.service.UnitSubcategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unitSubcategories")
public class UnitSubcategoryController extends ControllerTemplate<UnitSubcategoryDto, UnitSubcategoryCriteria, UnitSubcategoryService> {

    public UnitSubcategoryController(UnitSubcategoryService unitSubcategoryService) {
        super(unitSubcategoryService);
    }
}
