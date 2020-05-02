package Bit2c.api;

import Enums.AssetPairsEnum;

public final class Bit2cEndPoints {

    public static String BASE_API = "https://bit2c.co.il";
    public static String BASE_API_PUBLIC = "https://bit2c.co.il/Exchanges/";


    // public Endpoints
   public static String TICKER_INFO = "/Ticker.json";
    public static String ORDER_BOOK = "/orderbook.json";
    public static String ORDER_BOOK_TOP = "/orderbook-top.json";
    public static String Trades = "/lasttrades.json";




    // private Endpoints
    public static String PRIVATE_BALANCE = "/Account/Balance";
    public static String OPEN_ORDERS = "/Order/MyOrders";
    public static String ORDER_BY_ID = "/Order/GetById";
    public static String ACCOUNT_HISTORY = "/Order/AccountHistory";
    public static String ORDER_HISTORY = "/Order/OrderHistory";
    public static String ORDER_HISTORY_BY_ID = "/Order/HistoryByOrderId";
    public static String ADD_ORDER = "/Order/AddOrder";
    public static String CANCEL_ORDER = "/Order/CancelOrder";
    public static String ADD_BUY_MARKET_ORDER = "/Order/AddOrderMarketPriceBuy";
    public static String ADD_SELL_MARKET_ORDER = "/Order/AddOrderMarketPriceSell";
    public static String ADD_STOP_LIMIT_ORDER = "/Order/AddStopOrder";



    public static String url (String path) {
        return BASE_API + path;
    }



    private static String urlPublicPrefix() {
        return BASE_API_PUBLIC;
    }


    public static String createPublicUrl(AssetPairsEnum.AssetPairs pair, String endpointSuffix) {
        String fullURL = String.format("%s%s%s", Bit2cEndPoints.urlPublicPrefix(), pair,endpointSuffix);
        return fullURL;

    }
}