package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserTargetTrackerDto extends BaseDto {
    private UserTargetCategoryDto userTargetCategoryDto;
    private ProductDto productDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    private BigDecimal unit;
    private BigDecimal unitValue;
}
