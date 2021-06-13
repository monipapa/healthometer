package al.ikubinfo.healthometer.product.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCriteria extends BaseCriteria {
    private String name;
    private Long targetCategoryId;
    private Long unitSubcategoryId;
    private BigDecimal amountValue;
}
