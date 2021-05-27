package al.ikubinfo.healthometer.activity.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BmiDto {
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal bmi;
}
