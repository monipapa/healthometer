package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.BodyMeasurementCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyMeasurementCategoryRepository extends JpaRepository<BodyMeasurementCategoryEntity, Long> {
}
