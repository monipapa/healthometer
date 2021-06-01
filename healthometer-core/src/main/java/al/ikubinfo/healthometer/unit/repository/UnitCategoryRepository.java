package al.ikubinfo.healthometer.unit.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitCategoryRepository extends BaseJpaRepository<UnitCategoryEntity> {
}
