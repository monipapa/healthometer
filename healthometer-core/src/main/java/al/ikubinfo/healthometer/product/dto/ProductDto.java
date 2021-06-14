package al.ikubinfo.healthometer.product.dto;

import al.ikubinfo.commons.dto.BaseDto;
import al.ikubinfo.healthometer.target.dto.TargetCategoryDto;
import al.ikubinfo.healthometer.unit.dto.UnitSubcategoryDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto extends BaseDto {
    @NotBlank
    private String name;
    @NotNull(message = "Please enter target category")
    private TargetCategoryDto targetCategoryDto;
    @NotNull(message = "Please enter unit Subcategory")
    private UnitSubcategoryDto unitSubcategoryDto;
    @NotNull(message = "Please enter amount")
    private BigDecimal amountValue;
}
