package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.healthometer.activity.entity.UserTargetCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTargetCategoryRepository
    extends JpaRepository<UserTargetCategoryEntity, Long> {}
