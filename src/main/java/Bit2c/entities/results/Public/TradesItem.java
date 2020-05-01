package Bit2c.entities.results.Public;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradesItem {

    private long date;
    private boolean isBid;
    private BigDecimal price;
    private BigDecimal amount;
    private long tid;
}
