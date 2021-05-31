package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TargetDto extends BaseDto {
    private UserDto userDto;
    private TargetCategoryDto targetCategoryDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    private BigDecimal targetValue;
}
