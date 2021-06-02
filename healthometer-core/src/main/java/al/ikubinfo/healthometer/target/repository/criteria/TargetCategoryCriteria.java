package al.ikubinfo.healthometer.target.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class TargetCategoryCriteria extends BaseCriteria {
}
