package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.users.entity.StatusEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends BaseRepository<StatusEntity> {
  StatusEntity findByName(String name);
}
