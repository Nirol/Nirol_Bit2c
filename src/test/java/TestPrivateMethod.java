import Bit2c.api.NBit2c;
import Bit2c.entities.OrderHistory;
import Bit2c.entities.OrdersInput.NewLimitOrder;
import Bit2c.entities.OrdersInput.NewStopLimitOrder;
import Bit2c.entities.results.Private.AddOrder.AddOrderResponse;
import Bit2c.entities.results.Private.Balance.UserBalance;
import Bit2c.entities.results.Private.ExecutedOrder;
import Bit2c.entities.results.Private.MyOrders.MyOrdersWrapper;
import Bit2c.entities.results.Private.OrderById;
import Bit2c.entities.results.Private.OrderResponse;
import Enums.AssetPairsEnum;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestPrivateMethod {
    @Test
    public void testUserBalance() {
        UserBalance ub = new NBit2c().getAccountBalance();

    }

    @Test
    public void testGetMyOrders() {

        System.out.println();
        // all orders by pair type
       MyOrdersWrapper allOrdersResponse = new NBit2c().getMyOpenOrders(AssetPairsEnum.AssetPairs.BtcNis);

    Long id = allOrdersResponse.getBtcNis().getAsk().get(0).getId();
        System.out.println("order id="+id);
       // order by id
        OrderById order =  new NBit2c().getOrderById(id);







    }

    @Test
    public void testExecutedOrders() throws ParseException {


        String pattern = "dd-MM-yyyy HH:mm:ss.SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String dateFrom = "17-04-2020 11:59:36.392";
        Date d = simpleDateFormat.parse(dateFrom);
        long from = d.getTime();


        long dateTo = ( new Date() ).getTime();

        int take = 7;
        AssetPairsEnum.AssetPairs pt = AssetPairsEnum.AssetPairs.LtcNis;


        OrderHistory oh1 = OrderHistory.createOrderHistoryInput(from, dateTo, take, pt);
        ExecutedOrder[] executedOrders =  new NBit2c().getOrderHistory(oh1);

        try {
            Thread.sleep(200);
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        OrderHistory oh2 = OrderHistory.createOrderHistoryInput(from, dateTo);
        ExecutedOrder[] executedOrders2 =  new NBit2c().getOrderHistory(oh2);
        try {
            Thread.sleep(200);
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        OrderHistory oh3 = OrderHistory.createOrderHistoryInput(pt);
        ExecutedOrder[] executedOrders3 =  new NBit2c().getOrderHistory(oh3);
        try {
            Thread.sleep(200);
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        OrderHistory oh4 = OrderHistory.createOrderHistoryInput(take);
        ExecutedOrder[] executedOrders4 =  new NBit2c().getOrderHistory(oh4);
        try {
            Thread.sleep(200);
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        OrderHistory oh5 = OrderHistory.createOrderHistoryInput(pt, take);
        ExecutedOrder[] executedOrders5 =  new NBit2c().getOrderHistory(oh5);




    }



    @Test
    public void testAddOrder() throws ParseException {

        double orderAmount= 0.03;
        double orderPrice = 38900;
        boolean isBid = false;
        AssetPairsEnum.AssetPairs pair =  AssetPairsEnum.AssetPairs.BtcNis;
        NewLimitOrder orderInput = new NewLimitOrder(pair, isBid, orderAmount, orderPrice);


        AddOrderResponse limitOrderResponse = new NBit2c().addOrder(orderInput);




    }

    @Test
    public void testCancelOrder() throws ParseException {

        // id taken from get all my orders test
        long id = 268350853;


        OrderResponse cancelOrderResponse = new NBit2c().cancelOrder(id);

        System.out.println("debug spot");


    }

    @Test
    public void testAddStopLimitOrder() throws ParseException {

        double orderAmount= 0.03;
        double orderPrice = 38900;
        boolean isBid = false;
        AssetPairsEnum.AssetPairs pair =  AssetPairsEnum.AssetPairs.BtcNis;
        double stopPrice = 41900;
        NewStopLimitOrder orderInput = new NewStopLimitOrder(pair, isBid, orderAmount, orderPrice, stopPrice);


        AddOrderResponse limitOrderResponse = new NBit2c().addStopLimitOrder(orderInput);




    }




}
