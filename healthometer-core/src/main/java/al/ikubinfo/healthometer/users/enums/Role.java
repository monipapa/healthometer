package al.ikubinfo.healthometer.users.enums;

import lombok.Getter;

@Getter
public enum Role {
  ADMIN("admin"),
  EMPLOYEE("user");

  private String role;

  Role(String role) {
    this.role = role;
  }
}
