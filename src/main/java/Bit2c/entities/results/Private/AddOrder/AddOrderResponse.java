package Bit2c.entities.results.Private.AddOrder;


import lombok.Data;

@Data
public class AddOrderResponse {
    private Bit2c.entities.results.Private.OrderResponse OrderResponse;
    private NewOrder NewOrder;

}
