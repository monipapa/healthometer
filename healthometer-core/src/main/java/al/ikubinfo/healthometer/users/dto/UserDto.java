package al.ikubinfo.healthometer.users.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.activity.dto.MeasurementDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto extends BaseDto {
  private String username;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private RoleDto roleDto = new RoleDto();
  private StatusDto statusDto = new StatusDto();
  private List<MeasurementDto> bmiMeasurements;

}
