package al.ikubinfo.healthometer.users.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.users.enums.Status;
import lombok.*;

@Getter
@Setter
public class StatusDto extends BaseDto {
  private Status name;
  private String description;
}
