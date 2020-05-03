package Bit2c.entities.results.Public;

import lombok.Data;

import java.util.List;
@Data
public class OrderBook {

    private List< double[] > asks; // <price>, <volume>, <timestamp>
    private List< double[] > bids; // <price>, <volume>, <timestamp>

}


