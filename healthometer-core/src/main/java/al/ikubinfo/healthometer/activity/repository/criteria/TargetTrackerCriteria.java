package al.ikubinfo.healthometer.activity.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TargetTrackerCriteria extends BaseCriteria {
    private Long userTargetCategoryId;
    private Long productId;
    private Long unitSubcategoryId;
}
