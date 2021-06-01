package al.ikubinfo.healthometer.activity.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetRepository
    extends BaseJpaRepository<TargetEntity> {}
