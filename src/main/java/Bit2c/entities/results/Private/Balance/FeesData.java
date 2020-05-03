package Bit2c.entities.results.Private.Balance;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class FeesData {
    private BigDecimal FeeMaker;
    private BigDecimal FeeTaker;
}
