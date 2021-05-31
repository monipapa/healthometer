package al.ikubinfo.healthometer.unit.repository;

import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitCategoryRepository extends JpaRepository<UnitCategoryEntity, Long> {}
