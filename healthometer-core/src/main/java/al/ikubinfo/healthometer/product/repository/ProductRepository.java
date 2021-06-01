package al.ikubinfo.healthometer.product.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseJpaRepository<ProductEntity> {
}
