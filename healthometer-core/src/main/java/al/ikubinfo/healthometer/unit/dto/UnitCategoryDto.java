package al.ikubinfo.healthometer.unit.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class UnitCategoryDto extends BaseDto {
  @NotBlank
  private String name;
  @NotBlank
  private String description;
  @NotBlank
  private String defaultUnit;
  private List<UnitSubcategoryDto> subcategoryDtoList;
}
