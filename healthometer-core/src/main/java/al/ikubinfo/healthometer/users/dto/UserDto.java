package al.ikubinfo.healthometer.users.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDto extends BaseDto {
  @NotBlank
  private String username;
  @NotBlank
  private String firstname;
  @NotBlank
  private String lastname;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String password;
  @NotNull(message = "Please enter the role ! ")
  private RoleDto roleDto = new RoleDto();
  private StatusDto statusDto = new StatusDto();
}
