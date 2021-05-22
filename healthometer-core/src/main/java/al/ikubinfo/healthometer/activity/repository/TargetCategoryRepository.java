package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.TargetCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetCategoryRepository extends JpaRepository<TargetCategoryEntity, Long> {
}
