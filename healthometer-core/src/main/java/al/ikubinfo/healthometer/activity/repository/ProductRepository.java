package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
