package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TargetTrackerRepository extends BaseRepository<TargetTrackerEntity> {
    List<TargetTrackerEntity> findByProductEntity(ProductEntity productEntity);
}
