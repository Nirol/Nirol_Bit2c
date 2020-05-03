package Bit2c.api;


import Bit2c.entities.OrderHistory;
import Bit2c.entities.OrdersInput.NewLimitOrder;
import Bit2c.entities.OrdersInput.NewMarketBuyOrder;
import Bit2c.entities.OrdersInput.NewMarketSellOrder;
import Bit2c.entities.OrdersInput.NewStopLimitOrder;
import Bit2c.entities.results.Private.AddOrder.AddOrderResponse;
import Bit2c.entities.results.Private.OrderResponse;
import Bit2c.entities.results.Private.Balance.UserBalance;
import Bit2c.entities.results.Private.ExecutedOrder;
import Bit2c.entities.results.Private.MyOrders.MyOrdersWrapper;
import Bit2c.entities.results.Private.OrderById;
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

import java.util.HashMap;

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

    public MyOrdersWrapper getMyOpenOrders(AssetPairsEnum.AssetPairs pair) {
        var url = Bit2cEndPoints.url(OPEN_ORDERS);
        var params = new HashMap<String,Object>();
        params.put("pair", pair);
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.GET);
       ResponseEntity< MyOrdersWrapper > response =  new RestTemplate().exchange(requestsEntity, MyOrdersWrapper.class);
        return response.getBody();
    }

    public OrderById getOrderById(long id) {
        var url = Bit2cEndPoints.url(ORDER_BY_ID);
        var params = new HashMap<String,Object>();
        params.put("id", id);
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.GET);
        ResponseEntity< OrderById > response =  new RestTemplate().exchange(requestsEntity, OrderById.class);
        return response.getBody();
    }



    public AddOrderResponse addOrder(NewLimitOrder newOrderInput) {
        var url = Bit2cEndPoints.url(ADD_ORDER);
        var params = newOrderInput.asMap();
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.POST);
        ResponseEntity<AddOrderResponse> response = new RestTemplate().postForEntity(url, requestsEntity, AddOrderResponse.class);
        return response.getBody();
    }

// return OrderResponse object, same object as found in AddOrderResponse.

    public OrderResponse cancelOrder(long id) {
        var url = Bit2cEndPoints.url(CANCEL_ORDER);
        var params = new HashMap<String,Object>();
        params.put("id", id);
        var requestsEntity = ApiSign.getRequest(url,params, this.properties, HttpMethod.POST);
        ResponseEntity<OrderResponse> response = new RestTemplate().postForEntity(url, requestsEntity, OrderResponse.class);
        return response.getBody();
    }


    // was not tested ! use at your own risk!

    public AddOrderResponse addBuyOrderMarketPrice(NewMarketBuyOrder newOrderInput) {
        var url = Bit2cEndPoints.url(ADD_BUY_MARKET_ORDER);
        var params = newOrderInput.asMap();
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.POST);
        ResponseEntity<AddOrderResponse> response = new RestTemplate().postForEntity(url, requestsEntity, AddOrderResponse.class);
        return response.getBody();
    }

    // was not tested ! use at your own risk!

    public AddOrderResponse addSellOrderMarketPrice(NewMarketSellOrder newOrderInput) {
        var url = Bit2cEndPoints.url(ADD_SELL_MARKET_ORDER);
        var params = newOrderInput.asMap();
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.POST);
        ResponseEntity<AddOrderResponse> response = new RestTemplate().postForEntity(url, requestsEntity, AddOrderResponse.class);
        return response.getBody();
    }




    public AddOrderResponse addStopLimitOrder(NewStopLimitOrder newOrderInput) {
        var url = Bit2cEndPoints.url(ADD_STOP_LIMIT_ORDER);
        var params = newOrderInput.asMap();
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.POST);
        ResponseEntity<AddOrderResponse> response = new RestTemplate().postForEntity(url, requestsEntity, AddOrderResponse.class);
        return response.getBody();
    }




    public ExecutedOrder[] getOrderHistory(OrderHistory orderHistory) {
        var url = Bit2cEndPoints.url(ORDER_HISTORY);
        var params = orderHistory.asMap();
        var requestsEntity = ApiSign.getRequest(url, params, this.properties, HttpMethod.GET);
        try {
            Thread.sleep(300);
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        ResponseEntity<  ExecutedOrder[] > response =  new RestTemplate().exchange(requestsEntity, ExecutedOrder[].class);
        return response.getBody();
    }



}
