package al.ikubinfo.healthometer.unit.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitSubcategoryRepository extends BaseJpaRepository<UnitSubcategoryEntity> {}
