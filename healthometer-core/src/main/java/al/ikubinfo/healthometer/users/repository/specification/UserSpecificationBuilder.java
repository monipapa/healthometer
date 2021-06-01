package al.ikubinfo.healthometer.users.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import al.ikubinfo.healthometer.users.repository.criteria.UserCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserSpecificationBuilder extends SpecificationBuilder<UserEntity, UserCriteria> {

    @Override
    public Specification<UserEntity> filter(UserCriteria criteria) {
        Specification<UserEntity> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = Objects.requireNonNull(specification)
                    .and(equalsSpecification("id", criteria.getId()));
        }


        if (criteria.getFirstName() != null) {
            specification = Objects.requireNonNull(specification).and(
                    likeLowerSpecification("firstName", criteria.getFirstName()));
        }

        if (criteria.getLastName() != null) {
            specification = Objects.requireNonNull(specification).and(
                    likeLowerSpecification("lastName", criteria.getLastName()));
        }

        if (criteria.getStatusId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    ((root, query, criteriaBuilder)
                            -> criteriaBuilder.equal(root.get("status").get("id"), criteria.getStatusId())));
        }

        if (criteria.getRoleId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    ((root, query, criteriaBuilder)
                            -> criteriaBuilder.equal(root.get("role").get("id"), criteria.getRoleId())));
        }

        if (criteria.getEmail() != null) {
            specification = Objects.requireNonNull(specification).and(
                    likeLowerSpecification("email", criteria.getEmail()));
        }
        if (criteria.getUsername() != null) {
            specification = Objects.requireNonNull(specification).and(
                    likeLowerSpecification("username", criteria.getUsername()));
        }

        return specification;
    }

}
