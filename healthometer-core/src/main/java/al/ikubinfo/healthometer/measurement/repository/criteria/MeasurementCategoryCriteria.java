package al.ikubinfo.healthometer.measurement.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;

@Data
public class MeasurementCategoryCriteria extends BaseCriteria {
    private String name;
    private Long unitCategoryId;
}
