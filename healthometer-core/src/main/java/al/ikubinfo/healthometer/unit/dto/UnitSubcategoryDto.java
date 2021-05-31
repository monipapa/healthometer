package al.ikubinfo.healthometer.unit.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitSubcategoryDto extends BaseDto {
  private UnitCategoryDto unitCategoryDto;
  private String name;
  private String abbreviation;
}
