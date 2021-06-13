package al.ikubinfo.healthometer.users.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
  @NotNull(message = "Role should not be null!")
  private RoleEntity role;

  @ManyToOne
  @JoinColumn(name = "user_status_id")
  @NotNull
  private StatusEntity status;
}
