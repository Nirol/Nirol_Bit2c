package Bit2c.entities.results.Public;

import java.util.List;
import lombok.Data;
@Data
public class OrderBook {

    private List< double[] > asks; // <price>, <volume>, <timestamp>
    private List< double[] > bids; // <price>, <volume>, <timestamp>


    public List< double[] > getAsks(){
        return this.asks;
    }

    public List< double[] > getBids() {
        return this.bids;
    }



}


