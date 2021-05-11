package al.ikubinfo.healthometer.users.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
  ADMIN("admin"),
  USER("user");

  String role;
}
