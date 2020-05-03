



import Bit2c.api.NBit2c;
import Bit2c.entities.results.Public.OrderBook;
import Bit2c.entities.results.Public.Ticker;
import Bit2c.entities.results.Public.TradesItem;
import Enums.AssetPairsEnum;
import org.testng.annotations.Test;

import java.util.List;


public class testPublicMethods {



    @Test


    public void testtickerbit2c() {

        Ticker ticker = NBit2c.getTicker(AssetPairsEnum.AssetPairs.BtcNis);
        OrderBook ob = NBit2c.getOrderBookTop(AssetPairsEnum.AssetPairs.BtcNis);
        List< double[] > a = ob.getAsks();


        TradesItem[] trades = NBit2c.getPublicTrades(AssetPairsEnum.AssetPairs.BtcNis);

        System.out.println("acc");



    }
}
