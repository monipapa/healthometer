package al.ikubinfo.healthometer.users.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(schema = "healthometer",name = "status")
@Getter
@Setter
@NoArgsConstructor
public class StatusEntity extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;
}
