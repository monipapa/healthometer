package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.users.entity.StatusEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends BaseJpaRepository<StatusEntity> {
  StatusEntity findByName(String name);
}
