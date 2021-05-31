package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MeasurementDto extends BaseDto {
    private UserDto userDto;
    private MeasurementCategoryDto bodyMeasurementCategoryDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    private BigDecimal value;

}
