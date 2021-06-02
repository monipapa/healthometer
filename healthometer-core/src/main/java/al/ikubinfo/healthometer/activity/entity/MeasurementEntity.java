package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import al.ikubinfo.healthometer.measurement.entity.MeasurementCategoryEntity;
import al.ikubinfo.healthometer.unit.entity.UnitSubcategoryEntity;
import al.ikubinfo.healthometer.users.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(schema = "healthometer", name = "user_body_measurement")
@Getter
@Setter
public class MeasurementEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull
    @JsonBackReference
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "body_measurement_category_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private MeasurementCategoryEntity bodyMeasurementCategoryEntity;

    @ManyToOne
    @JoinColumn(name = "unit_subcategories_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UnitSubcategoryEntity unitSubcategoryEntity;

    @Column(name = "value")
    private BigDecimal value;
}
