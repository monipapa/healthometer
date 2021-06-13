package al.ikubinfo.healthometer.activity.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.activity.entity.TargetTrackerEntity;
import al.ikubinfo.healthometer.activity.repository.criteria.TargetTrackerCriteria;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TargetTrackerSpecificationBuilder
    extends SpecificationBuilder<TargetTrackerEntity, TargetTrackerCriteria> {
  @Override
  public Specification<TargetTrackerEntity> filter(TargetTrackerCriteria criteria) {
    Specification<TargetTrackerEntity> specification = Specification.where(null);

    if (criteria.getId() != null) {
      specification =
          Objects.requireNonNull(specification).and(equalsSpecification("id", criteria.getId()));
    }
    if (criteria.getProductId() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(equalsSpecification("productId", criteria.getProductId()));
    }
    if (criteria.getUnitSubcategoryId() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(equalsSpecification("unitSubcategoryId", criteria.getUnitSubcategoryId()));
    }

    return specification;
  }
}
