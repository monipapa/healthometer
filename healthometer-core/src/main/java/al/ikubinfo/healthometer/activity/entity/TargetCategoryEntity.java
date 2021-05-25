package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "healthometer", name = "target_category")
@Getter
@Setter
public class TargetCategoryEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "unit_categories_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UnitCategoryEntity unitCategoryEntity;
}
