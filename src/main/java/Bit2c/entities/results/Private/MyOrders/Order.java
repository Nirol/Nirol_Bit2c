package Bit2c.entities.results.Private.MyOrders;

import lombok.Data;

import java.math.BigDecimal;



@Data
public class Order {

    private Long created;
    private int type;
    private int order_type;


    private String status_type;
    private BigDecimal amount;
    private BigDecimal price;
    private BigDecimal stop;
    private Long id;
    private BigDecimal initialAmount;


}
