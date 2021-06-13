package al.ikubinfo.healthometer.measurement.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import al.ikubinfo.healthometer.measurement.repository.criteria.MeasurementCategoryCriteria;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MeasurementCategorySpecificationBuilder
    extends SpecificationBuilder<MeasurementCategoryEntity, MeasurementCategoryCriteria> {
  @Override
  public Specification<MeasurementCategoryEntity> filter(MeasurementCategoryCriteria criteria) {
    Specification<MeasurementCategoryEntity> specification = Specification.where(null);

    if (criteria.getId() != null) {
      specification =
          Objects.requireNonNull(specification).and(equalsSpecification("id", criteria.getId()));
    }

    if (criteria.getName() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(likeLowerCaseSpecification("name", criteria.getName()));
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
