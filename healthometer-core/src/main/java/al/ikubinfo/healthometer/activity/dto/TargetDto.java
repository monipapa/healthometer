package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class TargetDto extends BaseDto {
    @NotNull(message = "Please add user!")
    private UserDto userDto;
    @NotNull(message = "Please add target category!")
    private TargetCategoryDto targetCategoryDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    @NotNull(message = "Please add target value!")
    private BigDecimal targetValue;
}
