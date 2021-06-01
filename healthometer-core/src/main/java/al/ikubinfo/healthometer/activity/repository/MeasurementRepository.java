package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository
        extends BaseJpaRepository<MeasurementEntity> {
}
