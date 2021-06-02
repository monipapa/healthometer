package al.ikubinfo.healthometer.unit.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.target.entity.TargetCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitCategoryCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UnitCategorySpecificationBuilder extends SpecificationBuilder<UnitCategoryEntity, UnitCategoryCriteria> {
    @Override
    public Specification<UnitCategoryEntity> filter(UnitCategoryCriteria criteria) {
        Specification<UnitCategoryEntity> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = Objects.requireNonNull(specification)
                    .and(equalsSpecification("id", criteria.getId()));
        }

        return specification;
    }
}
