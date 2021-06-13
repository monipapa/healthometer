package al.ikubinfo.healthometer.unit.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.unit.repository.criteria.UnitSubcategoryCriteria;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UnitSubcategorySpecificationBuilder
    extends SpecificationBuilder<UnitSubcategoryEntity, UnitSubcategoryCriteria> {
  @Override
  public Specification<UnitSubcategoryEntity> filter(UnitSubcategoryCriteria criteria) {
    Specification<UnitSubcategoryEntity> specification = Specification.where(null);

    if (criteria.getId() != null) {
      specification =
          Objects.requireNonNull(specification).and(equalsSpecification("id", criteria.getId()));
    }
    if (criteria.getUnitCategoryId() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(
                  ((root, query, criteriaBuilder) ->
                      criteriaBuilder.equal(
                          root.get("unitCategoryEntity").get("id"), criteria.getUnitCategoryId())));
    }

    return specification;
  }
}
