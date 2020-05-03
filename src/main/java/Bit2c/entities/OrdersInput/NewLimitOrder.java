package Bit2c.entities.OrdersInput;

import Enums.AssetPairsEnum;
import lombok.var;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class NewLimitOrder  {


    private AssetPairsEnum.AssetPairs pair;
    private BigDecimal Amount;
    private BigDecimal Price;
    private boolean IsBid;



    public NewLimitOrder(AssetPairsEnum.AssetPairs pair,  boolean isBid, double orderAmount, double orderPrice) {
        this.pair = pair;
        this.Amount = BigDecimal.valueOf(orderAmount);
        this.Price = BigDecimal.valueOf(orderPrice);
        this.IsBid = isBid;

    }




    public Map<String, Object> asMap () {
        var result = new HashMap<String, Object>();
        result.put("Pair", this.pair);
        result.put("Price", String.valueOf(this.Price.longValue()));
        result.put("Amount", String.valueOf(this.Amount));
        result.put("IsBid", String.valueOf(this.IsBid));
        return result;
    }

}