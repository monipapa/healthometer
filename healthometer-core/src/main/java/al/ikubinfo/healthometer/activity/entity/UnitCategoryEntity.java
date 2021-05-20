package al.ikubinfo.healthometer.activity.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "healthometer", name = "unit_categories")
@Getter
@Setter
public class UnitCategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "default_unit")
    private String defaultUnit;

}
