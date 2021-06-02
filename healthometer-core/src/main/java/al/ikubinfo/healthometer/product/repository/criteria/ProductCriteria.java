package al.ikubinfo.healthometer.product.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import al.ikubinfo.healthometer.target.entity.TargetCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
public class ProductCriteria extends BaseCriteria {
    private String name;
    private Long targetCategoryId;
    private Long unitSubcategoryId;
    private BigDecimal amountValue;
}
