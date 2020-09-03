package al.ikubinfo.healthometer.users.enums;

import lombok.Getter;

@Getter
public enum Status {
  DELETED("deleted"),
  ACTIVE("active"),
  DISABLED("disabled");

  private String status;

  Status(String value) {
    this.status = value;
  }
}
