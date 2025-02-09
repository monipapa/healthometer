package al.ikubinfo.commons.repository;

import al.ikubinfo.commons.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

public interface BaseRepository<E extends BaseEntity>
        extends JpaSpecificationExecutor<E>, JpaRepository<E, Long> {
}
