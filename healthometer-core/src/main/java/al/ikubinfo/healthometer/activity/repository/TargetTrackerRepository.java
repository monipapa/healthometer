package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetTrackerRepository extends BaseJpaRepository<TargetTrackerEntity> {}
