package Bit2c.api;



import Bit2c.entities.results.Private.Balance.UserBalance;
import Bit2c.entities.results.Public.OrderBook;
import Bit2c.entities.results.Public.Ticker;

import Bit2c.entities.results.Public.TradesItem;
import Bit2c.utils.ApiSign;
import Bit2c.utils.LocalPropLoader;
import Enums.AssetPairsEnum;
import lombok.var;

import org.springframework.http.HttpMethod;
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

// public api requests
    public static Ticker getTicker(AssetPairsEnum.AssetPairs pair){
        var url = Bit2cEndPoints.createPublicUrl(pair, TICKER_INFO);
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity<Ticker> response =  new RestTemplate().exchange(requestsEntity,Ticker.class);
        return response.getBody();
    }


    public static OrderBook getOrderBook(AssetPairsEnum.AssetPairs pair) {
        var url =  Bit2cEndPoints.createPublicUrl(pair, ORDER_BOOK);                 //String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(ORDER_BOOK));
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity<OrderBook> response =  new RestTemplate().exchange(requestsEntity,OrderBook.class);

        return response.getBody();
    }


    public static OrderBook getOrderBookTop(AssetPairsEnum.AssetPairs pair) {
        var url =  Bit2cEndPoints.createPublicUrl(pair, ORDER_BOOK_TOP);    //String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(ORDER_BOOK_TOP));
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity<OrderBook> response =  new RestTemplate().exchange(requestsEntity,OrderBook.class);

        return response.getBody();
    }

    public static TradesItem[] getPublicTrades(AssetPairsEnum.AssetPairs pair) {
        var url =  Bit2cEndPoints.createPublicUrl(pair, Trades);   // String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,Bit2cEndPoints.urlPublicSuffix(Trades));
        var requestsEntity = ApiSign.getRequestPublic(url);
        ResponseEntity< TradesItem[]> response =  new RestTemplate().exchange(requestsEntity, TradesItem[].class);

        return response.getBody();
    }


    // Private api requests

    public  UserBalance getAccountBalance() {
        var url = Bit2cEndPoints.url(PRIVATE_BALANCE);
        var requestsEntity = ApiSign.getRequest(url, this.properties, HttpMethod.GET);
        ResponseEntity< UserBalance> response =  new RestTemplate().exchange(requestsEntity, UserBalance.class);
        return response.getBody();
    }





}
