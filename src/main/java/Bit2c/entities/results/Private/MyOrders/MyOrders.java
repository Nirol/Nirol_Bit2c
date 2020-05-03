package Bit2c.entities.results.Private.MyOrders;

import lombok.Data;

import java.util.ArrayList;
@Data
public class MyOrders {

    private ArrayList< Order > ask;
    private ArrayList< Order > bid;


}
