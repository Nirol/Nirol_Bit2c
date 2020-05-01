package Bit2c.api;



import Bit2c.entities.results.Private.UserBalance;
import Bit2c.entities.results.Public.OrderBook;
import Bit2c.entities.results.Public.Ticker;

import Bit2c.entities.results.Public.TradesItem;
import Bit2c.utils.ApiSign;
import Bit2c.utils.LocalPropLoader;
import Enums.AssetPairsEnum;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static Bit2c.api.Bit2cEndPoints.*;


public class NBit2c {

    private final LocalPropLoader properties;
    private final RestTemplate restTemplate;

    public NBit2c () {
        this.properties = new LocalPropLoader();
        this.restTemplate = new RestTemplate();
    }


    public static Ticker getTicker(AssetPairsEnum.AssetPairs pair){
        var url = String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(TICKER_INFO));

        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity<Ticker> response =  new RestTemplate().exchange(requestsEntity,Ticker.class);

       // ResponseEntity<Ticker> response = new RestTemplate().getForEntity(url,Ticker.class, );
        return response.getBody();
    }




    public static OrderBook getOrderBook(AssetPairsEnum.AssetPairs pair) {
        var url = String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(ORDER_BOOK));
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity<OrderBook> response =  new RestTemplate().exchange(requestsEntity,OrderBook.class);

        return response.getBody();
    }


    public static OrderBook getOrderBookTop(AssetPairsEnum.AssetPairs pair) {
        var url = String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(ORDER_BOOK_TOP));
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity<OrderBook> response =  new RestTemplate().exchange(requestsEntity,OrderBook.class);

        return response.getBody();
    }

    public static TradesItem[] getPublicTrades(AssetPairsEnum.AssetPairs pair) {
        var url = String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(Trades));
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity< TradesItem[]> response =  new RestTemplate().exchange(requestsEntity, TradesItem[].class);

        return response.getBody();
    }




    public UserBalance getAccountBalance () {
       // ApiSign.availableKeys(this.properties);
        var url = Bit2cEndPoints.url(PRIVATE_BALANCE);
        var requestsEntity = ApiSign.getRequest(url, KrakenEndpoints.PRIVATE_BALANCE, this.properties);
        ResponseEntity<AccountBalanceInfo> response = new RestTemplate().postForEntity(url, requestsEntity, AccountBalanceInfo.class);
        return response.getBody();
    }





}
