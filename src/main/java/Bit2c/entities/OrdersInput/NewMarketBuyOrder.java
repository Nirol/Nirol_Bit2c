package Bit2c.entities.OrdersInput;

import Enums.AssetPairsEnum;
import lombok.var;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class NewMarketBuyOrder  {



    private AssetPairsEnum.AssetPairs pair;
    private BigDecimal Total;


    public NewMarketBuyOrder(AssetPairsEnum.AssetPairs pair, double Total) {
        this.pair = pair;
        this.Total = BigDecimal.valueOf(Total);
       // this.pair = pair;
    }


    public Map<String, Object> asMap () {
        var result = new HashMap<String, Object>();
        result.put("Pair", this.pair);
        result.put("Total", String.valueOf(this.Total.longValue()));
        return result;
    }
}
