package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.measurement.dto.MeasurementCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import al.ikubinfo.healthometer.users.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class MeasurementDto extends BaseDto {
    @NotNull(message = "Please add user!")
    private UserDto userDto;
    @NotNull(message = "Please add measurement category!")
    private MeasurementCategoryDto bodyMeasurementCategoryDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    @NotNull(message = "Please add value!")
    private BigDecimal value;
}
