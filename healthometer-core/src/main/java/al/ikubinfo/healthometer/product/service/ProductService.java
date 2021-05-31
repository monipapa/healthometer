package al.ikubinfo.healthometer.product.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import al.ikubinfo.healthometer.product.mappers.ProductMapper;
import al.ikubinfo.healthometer.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceTemplate<
        ProductEntity,
        ProductDto,
        ProductMapper,
        ProductRepository> {

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }
}
