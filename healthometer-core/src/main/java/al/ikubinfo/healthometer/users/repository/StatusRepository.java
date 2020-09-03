package al.ikubinfo.healthometer.users.repository;

import al.ikubinfo.healthometer.users.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
  StatusEntity findByName(String name);
}
