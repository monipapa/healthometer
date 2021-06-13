package al.ikubinfo.healthometer.unit.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitSubcategoryRepository extends BaseRepository<UnitSubcategoryEntity> {
    List<UnitSubcategoryEntity> findByUnitCategoryEntity(UnitCategoryEntity unitCategoryEntity);
}
