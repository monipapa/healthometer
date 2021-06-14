package al.ikubinfo.healthometer.activity.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.product.dto.ProductDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class TargetTrackerDto extends BaseDto {
    @NotNull(message = "Please add a user target category!")
    private TargetDto userTargetCategoryDto;
    @NotNull(message = "Please add a product!")
    private ProductDto productDto;
    private UnitSubcategoryDto unitSubcategoryDto;
    @NotNull(message = "Please add unit!")
    private BigDecimal unit;
    private BigDecimal unitValue;
}
