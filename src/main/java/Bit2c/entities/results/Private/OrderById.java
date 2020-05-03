package Bit2c.entities.results.Private;

import Enums.PairType;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class OrderById {

    private PairType pair;
    private String status;
    private Long created;
    private int order_type;
    private int type;
    private BigDecimal amount;
    private BigDecimal initialAmount;
    private BigDecimal price;
    private  Long id;






}



