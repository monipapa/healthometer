package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.users.entity.RoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<RoleEntity> {
  RoleEntity findByName(String role);
}
