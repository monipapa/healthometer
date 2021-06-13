package al.ikubinfo.healthometer.product.service;

import al.ikubinfo.commons.exception.WarningEx;
import al.ikubinfo.commons.service.ServiceTemplate;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import al.ikubinfo.healthometer.activity.repository.TargetTrackerRepository;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import al.ikubinfo.healthometer.product.mappers.ProductMapper;
import al.ikubinfo.healthometer.product.repository.ProductRepository;
import al.ikubinfo.healthometer.product.repository.criteria.ProductCriteria;
import al.ikubinfo.healthometer.product.repository.specification.ProductSpecificationBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
        extends ServiceTemplate<
        ProductEntity,
        ProductDto,
        ProductMapper,
        ProductRepository,
        ProductCriteria,
        ProductSpecificationBuilder> {
    public TargetTrackerRepository targetTrackerRepository;

    public ProductService(
            ProductRepository repository,
            ProductMapper mapper,
            ProductSpecificationBuilder specificationBuilder,
            TargetTrackerRepository targetTrackerRepository) {
        super(repository, mapper, specificationBuilder);
        this.targetTrackerRepository = targetTrackerRepository;
    }

    @Override
    protected void doDelete(ProductEntity entity) {
        List<TargetTrackerEntity> targetTrackerList = targetTrackerRepository.findByProductEntity(entity);
        if (targetTrackerList != null) {
            throw new WarningEx("There are target tracker with this product!");
        }
        super.doDelete(entity);
    }
}
