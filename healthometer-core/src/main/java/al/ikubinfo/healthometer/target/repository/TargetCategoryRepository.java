package al.ikubinfo.healthometer.target.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.target.entity.TargetCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetCategoryRepository extends BaseJpaRepository<TargetCategoryEntity> {}
