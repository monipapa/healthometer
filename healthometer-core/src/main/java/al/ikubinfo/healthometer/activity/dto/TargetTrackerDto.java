package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TargetTrackerDto extends BaseDto {
    private TargetDto userTargetCategoryDto;
    private ProductDto productDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    private BigDecimal unit;
    private BigDecimal unitValue;
}
