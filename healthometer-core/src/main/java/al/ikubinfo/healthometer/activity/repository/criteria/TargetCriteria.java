package al.ikubinfo.healthometer.activity.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TargetCriteria extends BaseCriteria {
    private Long userId;
    private Long targetCategoryId;
    private Long unitSubcategoryId;
    private BigDecimal targetValue;
}
