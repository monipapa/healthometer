package al.ikubinfo.healthometer.product.controller;

import al.ikubinfo.commons.controller.ControllerTemplate;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.product.repository.criteria.ProductCriteria;
import al.ikubinfo.healthometer.product.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController
        extends ControllerTemplate<ProductDto, ProductCriteria, ProductService> {
    public ProductController(ProductService productService) {
        super(productService);
    }
}
