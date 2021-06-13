package al.ikubinfo.healthometer.product.service;

import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import al.ikubinfo.healthometer.product.mappers.ProductMapper;
import al.ikubinfo.healthometer.product.repository.ProductRepository;
import al.ikubinfo.healthometer.product.repository.criteria.ProductCriteria;
import al.ikubinfo.healthometer.product.repository.specification.ProductSpecificationBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProductService
        extends ServiceTemplate<
        ProductEntity,
        ProductDto,
        ProductMapper,
        ProductRepository,
        ProductCriteria,
        ProductSpecificationBuilder> {

    public ProductService(
            ProductRepository repository,
            ProductMapper mapper,
            ProductSpecificationBuilder specificationBuilder) {
        super(repository, mapper, specificationBuilder);
    }
}
