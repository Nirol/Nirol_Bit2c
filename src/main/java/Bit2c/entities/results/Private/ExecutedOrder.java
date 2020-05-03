package Bit2c.entities.results.Private;


import lombok.Data;

@Data
public class ExecutedOrder {

    private String firstCoin;
    private String secondCoin;
    private String feeCoin;

    private String firstAmount;
    private String secondAmount;

    private String firstAmountBalance;
    private String     secondAmountBalance;

    private String feeAmount;

    private String fee;

    private String created;
    private String ticks;
    private String price;
    private String reference;



    // action main codes:
    // buy = 0
    // sell = 1
    private int action;



}
