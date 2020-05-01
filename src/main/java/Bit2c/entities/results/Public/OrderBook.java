package Bit2c.entities.results.Public;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.var;



@Data
public class OrderBook {


    private List< double[] > asks; // <price>, <volume>, <timestamp>
    private List< double[] > bids; // <price>, <volume>, <timestamp>

    @JsonCreator
    public OrderBook(@JsonProperty("result") Map< String, Map< String, Object > > result) {
        var pair = result.entrySet().stream().findFirst().get();


        var lists = pair.getValue();
        var asks = ( List ) lists.get("asks");
        var a = asks.stream().map(l -> {
            var list = ( List< Object > ) l;
            var values = list.stream().mapToDouble(i -> Double.parseDouble(i.toString())).boxed().collect(Collectors.toList());
            return values;
        }).collect(Collectors.toList());
        this.asks = ( List< double[] > ) a;
        var bids = ( List ) lists.get("bids");
        var b = bids.stream().map(l -> {
            var list = ( List< Object > ) l;
            var values = list.stream().mapToDouble(i -> Double.parseDouble(i.toString())).boxed().collect(Collectors.toList());
            return values;
        }).collect(Collectors.toList());
        this.bids = ( List< double[] > ) b;
    }





    public List< double[] > getAsks(){
        return this.asks;
    }


    public List< double[] > getBids() {
        return this.bids;
    }





}


