package al.ikubinfo.healthometer.measurement.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.healthometer.unit.entity.UnitCategoryEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "healthometer", name = "body_measurement_categories")
@Getter
@Setter
public class MeasurementCategoryEntity extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "unit_categories_id", referencedColumnName = "id", nullable = false)
  @NotNull
  @JsonBackReference
  private UnitCategoryEntity unitCategoryEntity;
}
