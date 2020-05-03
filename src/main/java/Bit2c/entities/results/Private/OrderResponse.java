package Bit2c.entities.results.Private;


import lombok.Data;


// OrderResponse object returned from CancleOrder api request and as part of the results of AddOrder request.
@Data
public class OrderResponse {
    private boolean HasError;
    private String Error;
}
