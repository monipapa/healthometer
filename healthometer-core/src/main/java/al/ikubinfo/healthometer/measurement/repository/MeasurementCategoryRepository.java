package al.ikubinfo.healthometer.measurement.repository;

import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementCategoryRepository
    extends JpaRepository<MeasurementCategoryEntity, Long> {}
