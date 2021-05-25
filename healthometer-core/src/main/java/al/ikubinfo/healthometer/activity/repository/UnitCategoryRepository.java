package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.UnitCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitCategoryRepository extends JpaRepository<UnitCategoryEntity, Long> {}
