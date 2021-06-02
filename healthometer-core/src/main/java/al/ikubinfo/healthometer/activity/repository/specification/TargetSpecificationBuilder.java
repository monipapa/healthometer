package al.ikubinfo.healthometer.activity.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.activity.entity.TargetEntity;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TargetSpecificationBuilder extends SpecificationBuilder<TargetEntity, TargetCriteria> {
    @Override
    public Specification<TargetEntity> filter(TargetCriteria criteria) {
        Specification<TargetEntity> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = Objects.requireNonNull(specification)
                    .and(equalsSpecification("id", criteria.getId()));
        }

        if (criteria.getUserId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    equalsSpecification("userId", criteria.getUserId()));
        }
        if (criteria.getTargetCategoryId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    equalsSpecification("targetCategoryId", criteria.getTargetCategoryId()));
        }
        if (criteria.getUnitSubcategoryId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    equalsSpecification("unitSubcategoryId", criteria.getUnitSubcategoryId()));
        }

        return specification;
    }
}
