package Bit2c.entities.results.Private.MyOrders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class MyOrdersWrapper {


    private MyOrders BtcNis;
    private MyOrders LtcNis;
    private MyOrders BchabcNis;
    private MyOrders GrinNis;
    private  MyOrders EthNis;

}
