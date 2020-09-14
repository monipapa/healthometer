package al.ikubinfo.healthometer.users.enums;

import lombok.Getter;

@Getter
public enum Status {
  DELETED("DELETED"),
  ACTIVE("ACTIVE"),
  DISABLED("DISABLED");

  private String status;

  Status(String value) {
    this.status = value;
  }
}
