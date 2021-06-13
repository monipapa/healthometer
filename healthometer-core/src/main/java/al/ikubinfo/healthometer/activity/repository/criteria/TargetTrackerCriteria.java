package al.ikubinfo.healthometer.activity.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

@Data
public class TargetTrackerCriteria extends BaseCriteria {
    private Long userTargetCategoryId;
    private Long productId;
    private Long unitSubcategoryId;
}
