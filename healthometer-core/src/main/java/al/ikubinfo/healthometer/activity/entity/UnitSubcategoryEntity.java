package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "healthometer", name = "unit_subcategories")
@Getter
@Setter
public class UnitSubcategoryEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "unit_categories_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private UnitCategoryEntity unitCategoryEntity;

    @Column(name = "name")
    private String name;

    //@Column(name = "abbreviation")
    private String abbreviation;

}
