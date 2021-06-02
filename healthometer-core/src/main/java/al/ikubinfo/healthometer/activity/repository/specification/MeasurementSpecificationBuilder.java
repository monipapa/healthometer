package al.ikubinfo.healthometer.activity.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import al.ikubinfo.healthometer.activity.repository.criteria.MeasurementCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MeasurementSpecificationBuilder extends SpecificationBuilder<MeasurementEntity, MeasurementCriteria> {

    @Override
    public Specification<MeasurementEntity> filter(MeasurementCriteria criteria) {
        Specification<MeasurementEntity> specification = Specification.where(null);

        if (criteria.getId() != null) {
            specification = Objects.requireNonNull(specification)
                    .and(equalsSpecification("id", criteria.getId()));
        }


        if (criteria.getUserId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    ((root, query, criteriaBuilder)
                            -> criteriaBuilder.equal(root.get("userEntity").get("id"), criteria.getUserId())));
        }
        if (criteria.getBodyMeasurementCategoryId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    ((root, query, criteriaBuilder)
                            -> criteriaBuilder.equal(root.get("bodyMeasurementCategoryEntity").get("id"), criteria.getBodyMeasurementCategoryId())));
        }
        if (criteria.getUnitSubcategoryId() != null) {
            specification = Objects.requireNonNull(specification).and(
                    ((root, query, criteriaBuilder)
                            -> criteriaBuilder.equal(root.get("unitSubcategoryEntity").get("id"), criteria.getUnitSubcategoryId())));
        }

        return specification;
    }

}
