package al.ikubinfo.healthometer.product.repository.specification;

import al.ikubinfo.commons.specification.SpecificationBuilder;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import al.ikubinfo.healthometer.product.repository.criteria.ProductCriteria;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProductSpecificationBuilder
    extends SpecificationBuilder<ProductEntity, ProductCriteria> {
  @Override
  public Specification<ProductEntity> filter(ProductCriteria criteria) {
    Specification<ProductEntity> specification = Specification.where(null);

    if (criteria.getId() != null) {
      specification =
          Objects.requireNonNull(specification).and(equalsSpecification("id", criteria.getId()));
    }

    if (criteria.getName() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(likeLowerCaseSpecification("name", criteria.getName()));
    }
    if (criteria.getAmountValue() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(equalsSpecification("amountValue", criteria.getAmountValue()));
    }
    if (criteria.getTargetCategoryId() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(
                  ((root, query, criteriaBuilder) ->
                      criteriaBuilder.equal(
                          root.get("targetCategoryEntity").get("id"),
                          criteria.getTargetCategoryId())));
    }
    if (criteria.getUnitSubcategoryId() != null) {
      specification =
          Objects.requireNonNull(specification)
              .and(
                  ((root, query, criteriaBuilder) ->
                      criteriaBuilder.equal(
                          root.get("unitSubcategoryEntity").get("id"),
                          criteria.getUnitSubcategoryId())));
    }

    return specification;
  }
}
