package al.ikubinfo.healthometer.measurement.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.measurement.repository.criteria.MeasurementCategoryCriteria;
import al.ikubinfo.healthometer.measurement.service.MeasurementCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("measurementCategories")
public class MeasurementCategoryController extends ControllerTemplate<MeasurementCategoryDto, MeasurementCategoryCriteria,
        MeasurementCategoryService> {
    public MeasurementCategoryController(MeasurementCategoryService measurementCategoryService) {
        super(measurementCategoryService);
    }
}
