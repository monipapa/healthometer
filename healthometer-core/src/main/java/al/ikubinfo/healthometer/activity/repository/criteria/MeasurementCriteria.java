package al.ikubinfo.healthometer.activity.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

@Data
public class MeasurementCriteria extends BaseCriteria {
  private Long userId;
  private Long bodyMeasurementCategoryId;
  private Long unitSubcategoryId;
}
