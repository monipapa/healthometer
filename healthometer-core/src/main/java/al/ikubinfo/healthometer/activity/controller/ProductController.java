package al.ikubinfo.healthometer.activity.controller;

import al.ikubinfo.commons.controller.AbstractController;
import al.ikubinfo.healthometer.activity.dto.ProductDto;
import al.ikubinfo.healthometer.activity.service.ProductService;

public class ProductController extends AbstractController<ProductDto,
        ProductService> {
    public ProductController(ProductService service) {
        super(service);
    }
}
