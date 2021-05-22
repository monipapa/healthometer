package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.ProductEntity;
import al.ikubinfo.healthometer.activity.entity.UserTargetTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTargetTrackerRepository extends JpaRepository<UserTargetTrackerEntity, Long> {
}
