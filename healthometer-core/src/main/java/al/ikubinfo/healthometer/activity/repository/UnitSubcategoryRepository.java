package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.UnitSubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitSubcategoryRepository extends JpaRepository<UnitSubcategoryEntity, Long> {
}
