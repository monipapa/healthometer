package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(schema = "healthometer", name = "user_target_tracker")
@Getter
@Setter
public class UserTargetTrackerEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_target_category_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UserTargetCategoryEntity userTargetCategoryEntity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "unit_subcategories_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UnitSubcategoryEntity unitSubcategoryEntity;

    @Column(name = "unit")
    private BigDecimal unit;

    @Column(name = "unit_value")
    private BigDecimal unitValue;
}
