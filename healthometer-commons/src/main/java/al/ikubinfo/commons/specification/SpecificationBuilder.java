package al.ikubinfo.commons.specification;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.commons.entity.BaseEntity;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class SpecificationBuilder<E extends BaseEntity, C extends BaseCriteria> {

  public abstract Specification<E> filter(C criteria);

  protected <T> Specification<E> equalsSpecification(String fieldName, T value) {
    return (root, query, builder) -> builder.equal(root.get(fieldName), value);
  }

  protected Specification<E> likeLowerCaseSpecification(String fieldName, String value) {
    return (Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) ->
        builder.like(builder.lower(root.get(fieldName)), wrapLikeQuery(value));
  }

  protected static String wrapLikeQuery(String txt) {
    return "%" + txt.toLowerCase() + "%";
  }
}
