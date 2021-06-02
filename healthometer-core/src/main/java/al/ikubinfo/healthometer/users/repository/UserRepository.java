package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.commons.repository.BaseRepository;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
  UserEntity findByUsername(String username);
}
