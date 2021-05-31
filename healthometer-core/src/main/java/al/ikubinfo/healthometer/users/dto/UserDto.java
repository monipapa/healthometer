package al.ikubinfo.healthometer.users.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto extends BaseDto {
  private String username;
  private String firstname;
  private String lastname;
  private String email;
  //private String password;
  private RoleDto roleDto = new RoleDto();
  private StatusDto statusDto = new StatusDto();
}
