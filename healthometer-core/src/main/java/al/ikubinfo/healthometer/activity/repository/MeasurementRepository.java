package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends BaseRepository<MeasurementEntity> {
    List<MeasurementEntity> findByBodyMeasurementCategoryEntity(MeasurementCategoryEntity measurementCategoryEntity);
}
