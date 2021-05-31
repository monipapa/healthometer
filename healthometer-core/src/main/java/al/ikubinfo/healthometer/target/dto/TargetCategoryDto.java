package al.ikubinfo.healthometer.target.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.unit.dto.UnitCategoryDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetCategoryDto extends BaseDto {
    private String name;
    private String description;
    private UnitCategoryDto unitCategoryDto;
}
