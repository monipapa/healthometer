package al.ikubinfo.healthometer.activity.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

@Data
public class TargetCriteria extends BaseCriteria {
    private Long userId;
    private Long targetCategoryId;
    private Long unitSubcategoryId;
}
