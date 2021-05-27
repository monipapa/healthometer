package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.AbstractController;
import al.ikubinfo.healthometer.activity.dto.BodyMeasurementCategoryDto;
import al.ikubinfo.healthometer.activity.service.BodyMeasurementCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("measurementCategory")
public class BodyMeasurementCategoryController extends AbstractController<BodyMeasurementCategoryDto,
        BodyMeasurementCategoryService> {

        //TODO override controllers for @PreAuthorize("hasAnyAuthority('admin')") or define in SecurityConfig class
        public BodyMeasurementCategoryController(BodyMeasurementCategoryService service) {
                super(service);
        }
}
