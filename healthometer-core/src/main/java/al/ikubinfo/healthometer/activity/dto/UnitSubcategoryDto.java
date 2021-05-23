package al.ikubinfo.healthometer.activity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitSubcategoryDto {
    private Long id;
    private UnitCategoryDto unitCategoryDto;
    private String name;
    private String abbreviation;
}
