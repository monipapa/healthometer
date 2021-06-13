package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.healthometer.product.entity.ProductEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import com.sun.istack.NotNull;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "healthometer", name = "user_target_tracker")
@Getter
@Setter
public class TargetTrackerEntity extends BaseEntity {
  @ManyToOne
  @JoinColumn(name = "user_target_category_id", referencedColumnName = "id", nullable = false)
  @NotNull
  private TargetEntity userTargetCategoryEntity;

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
