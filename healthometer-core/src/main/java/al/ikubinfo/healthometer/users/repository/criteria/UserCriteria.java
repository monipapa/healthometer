package al.ikubinfo.healthometer.users.repository.criteria;

import al.ikubinfo.commons.dto.BaseCriteria;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCriteria extends BaseCriteria {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Long roleId;
    private Long statusId;
}