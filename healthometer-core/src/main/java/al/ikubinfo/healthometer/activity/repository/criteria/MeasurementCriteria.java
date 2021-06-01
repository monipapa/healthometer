package al.ikubinfo.healthometer.activity.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class MeasurementCriteria extends BaseCriteria {
    private Long userId;
    private Long bodyMeasurementCategoryId;
    private Long unitSubcategoryId;
    private BigDecimal value;
    private Long maxId;
}