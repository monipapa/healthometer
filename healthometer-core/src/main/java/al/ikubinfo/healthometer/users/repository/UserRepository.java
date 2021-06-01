package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.commons.repository.BaseJpaRepository;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseJpaRepository<UserEntity> {
  UserEntity findByUsername(String username);
}
