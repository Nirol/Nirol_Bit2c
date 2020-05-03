package Bit2c.entities.OrdersInput;

import Enums.AssetPairsEnum;
import lombok.var;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class NewStopLimitOrder {




    private BigDecimal Amount;
    private BigDecimal Price;
    private BigDecimal Stop;
    private boolean IsBid;
    private AssetPairsEnum.AssetPairs pair;



    public NewStopLimitOrder(AssetPairsEnum.AssetPairs pair,  boolean isBid, double orderAmount, double orderPrice, double stopPrice) {
        this.Amount = BigDecimal.valueOf(orderAmount);
        this.Price = BigDecimal.valueOf(orderPrice);
        this.IsBid = isBid;
        this.pair = pair;
        this.Stop = BigDecimal.valueOf(stopPrice);
    }




    public Map<String, Object> asMap () {
        var result = new HashMap<String, Object>();
        result.put("Pair", this.pair);
        result.put("Price", String.valueOf(this.Price.longValue()));
        result.put("Amount", String.valueOf(this.Amount));
        result.put("IsBid", String.valueOf(this.IsBid));
        result.put("Stop", String.valueOf(this.Stop));
        return result;
    }
}
