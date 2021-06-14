package al.ikubinfo.healthometer.target.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TargetCategoryDto extends BaseDto {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull(message = "Please add unit category!")
    private UnitCategoryDto unitCategoryDto;
}
