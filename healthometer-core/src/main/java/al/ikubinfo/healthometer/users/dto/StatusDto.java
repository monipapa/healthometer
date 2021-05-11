package al.ikubinfo.healthometer.users.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDto extends BaseDto {
  private String name;
  private String description;
}
