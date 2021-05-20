package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(schema = "healthometer", name = "user_target_category")
@Getter
@Setter
public class UserTargetCategoryEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "target_category_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private TargetCategoryEntity targetCategoryEntity;

    @ManyToOne
    @JoinColumn(name = "unit_subcategories_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UnitSubcategoryEntity unitSubcategoryEntity;

    @Column(name = "target_value")
    private BigDecimal targetValue;
}
