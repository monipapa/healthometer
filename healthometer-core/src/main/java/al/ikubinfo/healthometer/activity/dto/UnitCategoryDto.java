package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitCategoryDto extends BaseDto {
  private String name;
  private String description;
  private String defaultUnit;
  private List<UnitSubcategoryDto> subcategoryDtoList;
}
