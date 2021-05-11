package al.ikubinfo.healthometer.users.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  DELETED("deleted"),
  ACTIVE("active"),
  DISABLED("disabled");

  String status;
}
