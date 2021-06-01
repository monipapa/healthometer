package al.ikubinfo.healthometer.measurement.controller;

import al.ikubinfo.commons.controller.ControllerTemplateSimple;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.measurement.service.MeasurementCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("measurementCategory")
public class MeasurementCategoryController extends ControllerTemplateSimple<MeasurementCategoryDto,
        MeasurementCategoryService> {

        //TODO override controllers for @PreAuthorize("hasAnyAuthority('admin')") or define in SecurityConfig class
        public MeasurementCategoryController(MeasurementCategoryService service) {
                super(service);
        }
}
