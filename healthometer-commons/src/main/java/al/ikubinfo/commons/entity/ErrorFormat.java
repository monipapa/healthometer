package al.ikubinfo.commons.entity;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorFormat {
  private String message;
  private Date timeStamp = new Date();
  private String exception;
}
