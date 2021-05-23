package al.ikubinfo.healthometer.activity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UnitCategoryDto {
    private Long id;
    private String name;
    private String description;
    private String defaultUnit;
    private List<UnitSubcategoryDto> subcategoryDtoList;
}
