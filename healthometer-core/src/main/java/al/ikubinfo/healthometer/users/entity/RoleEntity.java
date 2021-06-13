package al.ikubinfo.healthometer.users.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "healthometer", name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

  @Column(name = "name")
  protected String name;

  @Column(name = "description")
  private String description;
}
