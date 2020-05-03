package Bit2c.entities.results.Private.AddOrder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewOrder {
    private Long created;
    private String type;
    private BigDecimal amount;
    private BigDecimal price;
    private Long id;
// only avilable on stop limit order
    private BigDecimal stop;



}
