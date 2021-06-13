package al.ikubinfo.healthometer.unit.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "healthometer", name = "unit_subcategories")
@Getter
@Setter
public class UnitSubcategoryEntity extends BaseEntity {
  @ManyToOne
  @JoinColumn(name = "unit_categories_id", referencedColumnName = "id", nullable = false)
  @NotNull
  @JsonBackReference
  private UnitCategoryEntity unitCategoryEntity;

  @Column(name = "name")
  private String name;

  @Column(name = "abbreviation")
  private String abbreviation;
}
