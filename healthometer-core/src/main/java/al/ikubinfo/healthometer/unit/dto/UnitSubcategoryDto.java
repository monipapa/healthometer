package al.ikubinfo.healthometer.unit.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UnitSubcategoryDto extends BaseDto {
  @NotNull(message = "Please add unit category!")
  private UnitCategoryDto unitCategoryDto;
  @NotBlank
  private String name;
  @NotBlank
  private String abbreviation;
}
