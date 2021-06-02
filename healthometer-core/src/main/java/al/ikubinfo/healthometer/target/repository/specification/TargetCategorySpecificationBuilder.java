package al.ikubinfo.healthometer.target.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.target.entity.TargetCategoryEntity;
import al.ikubinfo.healthometer.target.repository.criteria.TargetCategoryCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TargetCategorySpecificationBuilder extends SpecificationBuilder<TargetCategoryEntity, TargetCategoryCriteria> {
    @Override
    public Specification<TargetCategoryEntity> filter(TargetCategoryCriteria criteria) {
        Specification<TargetCategoryEntity> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = Objects.requireNonNull(specification)
                    .and(equalsSpecification("id", criteria.getId()));
        }

        return specification;
    }
}
