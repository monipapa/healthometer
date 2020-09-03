package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.healthometer.users.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
  RoleEntity findByName(String role);
}
