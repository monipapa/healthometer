package al.ikubinfo.healthometer.users.dto;

import al.ikubinfo.commons.validation.Validatable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthDto implements Validatable {

  private boolean valid = false;

  private String username;
  private String password;
}
