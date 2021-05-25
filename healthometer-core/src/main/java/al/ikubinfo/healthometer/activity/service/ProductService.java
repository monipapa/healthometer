package al.ikubinfo.healthometer.activity.service;

import al.ikubinfo.commons.service.AbstractService;
import al.ikubinfo.healthometer.activity.dto.ProductDto;
import al.ikubinfo.healthometer.activity.entity.ProductEntity;
import al.ikubinfo.healthometer.activity.mappers.ProductMapper;
import al.ikubinfo.healthometer.activity.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<
        ProductEntity,
        ProductDto,
        ProductMapper,
        ProductRepository> {

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }
}
