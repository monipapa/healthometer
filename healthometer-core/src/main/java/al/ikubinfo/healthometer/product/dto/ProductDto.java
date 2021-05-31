package al.ikubinfo.healthometer.product.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
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
