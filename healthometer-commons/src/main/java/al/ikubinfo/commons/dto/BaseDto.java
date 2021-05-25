package al.ikubinfo.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDto {
    protected Long id;
    protected LocalDateTime dateCreated;
    protected LocalDateTime dateUpdated;
    protected String userCreated;
    protected String userUpdated;
}
