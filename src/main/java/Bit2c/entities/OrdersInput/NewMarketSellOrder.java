package Bit2c.entities.OrdersInput;

import Enums.AssetPairsEnum;
import lombok.var;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class NewMarketSellOrder {



    private AssetPairsEnum.AssetPairs pair;
    private BigDecimal Amount;


    public NewMarketSellOrder(AssetPairsEnum.AssetPairs pair, double Amount) {
        this.Amount = BigDecimal.valueOf(Amount);
        this.pair = pair;
    }




    public Map<String, Object> asMap () {
        var result = new HashMap<String, Object>();
        result.put("Pair", this.pair);
        result.put("Amount", String.valueOf(this.Amount.longValue()));
        return result;
    }
}
