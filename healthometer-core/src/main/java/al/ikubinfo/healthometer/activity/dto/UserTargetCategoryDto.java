package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserTargetCategoryDto extends BaseDto {
    private UserDto userDto;
    private TargetCategoryDto targetCategoryDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    private BigDecimal targetValue;
}
