package al.ikubinfo.commons.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
  protected Long id;
  protected LocalDate dateCreated;
  protected LocalDate dateUpdated;
  protected Long userCreatedId;
  protected Long userUpdatedId;
}
