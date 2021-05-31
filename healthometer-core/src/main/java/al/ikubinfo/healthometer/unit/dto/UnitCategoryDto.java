package al.ikubinfo.healthometer.unit.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnitCategoryDto extends BaseDto {
  private String name;
  private String description;
  private String defaultUnit;
  private List<UnitSubcategoryDto> subcategoryDtoList;
}
