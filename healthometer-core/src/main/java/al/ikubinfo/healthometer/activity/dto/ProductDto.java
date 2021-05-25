package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto extends BaseDto {
    private String name;
    private TargetCategoryDto targetCategoryDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    private BigDecimal amountValue;
}
