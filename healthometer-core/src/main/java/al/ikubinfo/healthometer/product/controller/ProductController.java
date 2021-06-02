package al.ikubinfo.healthometer.product.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.commons.controller.ControllerTemplateSimple;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.product.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController extends ControllerTemplateSimple<ProductDto,
        ProductService> {
    public ProductController(ProductService service) {
        super(service);
    }
}
