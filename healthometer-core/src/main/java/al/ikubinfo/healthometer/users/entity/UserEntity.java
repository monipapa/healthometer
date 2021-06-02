package al.ikubinfo.healthometer.users.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import javax.persistence.*;

import al.ikubinfo.healthometer.activity.entity.MeasurementEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(schema = "healthometer", name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

  @Column(name = "email")
  private String email;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "firstname")
  private String firstname;

  @Column(name = "lastname")
  private String lastname;

  @ManyToOne
  @JoinColumn(name = "user_role_id")
  private RoleEntity role;

  @ManyToOne
  @JoinColumn(name = "user_status_id")
  private StatusEntity status;

  @OneToMany(mappedBy = "userEntity")
  @Where(clause = "body_measurement_category_id=3")
  @JsonManagedReference
  private List<MeasurementEntity> bmiMeasurements;
}
