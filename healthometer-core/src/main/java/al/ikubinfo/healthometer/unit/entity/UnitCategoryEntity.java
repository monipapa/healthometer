package al.ikubinfo.healthometer.unit.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "healthometer", name = "unit_categories")
@Getter
@Setter
public class UnitCategoryEntity extends BaseEntity {
    @OneToMany(mappedBy = "unitCategoryEntity", fetch = FetchType.LAZY)
    @JsonManagedReference
    List<UnitSubcategoryEntity> subcategoryEntityList;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "default_unit")
    private String defaultUnit;
}
