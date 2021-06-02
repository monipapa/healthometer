package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends BaseRepository<MeasurementEntity> {
}
