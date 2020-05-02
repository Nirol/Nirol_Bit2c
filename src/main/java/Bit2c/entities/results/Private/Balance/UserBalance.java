package Bit2c.entities.results.Private.Balance;


import java.math.BigDecimal;
import lombok.Data;


@Data
public class UserBalance {

    private BigDecimal AVAILABLE_NIS;
    private BigDecimal NIS;
    private BigDecimal LOCKED_NIS;
    private BigDecimal ESTIMATED_BALANCE_NIS_IN_NIS;

    private BigDecimal AVAILABLE_BTC;
    private BigDecimal BTC;
    private BigDecimal LOCKED_BTC;
    private BigDecimal ESTIMATED_BALANCE_BTC_IN_NIS;

    private BigDecimal AVAILABLE_ETH;
    private BigDecimal ETH;
    private BigDecimal LOCKED_ETH;
    private BigDecimal ESTIMATED_BALANCE_ETH_IN_NIS;

    private BigDecimal AVAILABLE_BCHSV;
    private BigDecimal BCHSV;
    private BigDecimal LOCKED_BCHSV;

    private BigDecimal AVAILABLE_BCHABC;
    private BigDecimal BCHABC;
    private BigDecimal LOCKED_BCHABC;
    private BigDecimal ESTIMATED_BALANCE_BCHABC_IN_NIS;


    private BigDecimal AVAILABLE_LTC;
    private BigDecimal LTC;
    private BigDecimal LOCKED_LTC;
    private BigDecimal ESTIMATED_BALANCE_LTC_IN_NIS;


    private BigDecimal AVAILABLE_ETC;
    private BigDecimal ETC;
    private BigDecimal LOCKED_ETC;

    private BigDecimal AVAILABLE_BTG;
    private BigDecimal BTG;
    private BigDecimal LOCKED_BTG;

    private BigDecimal AVAILABLE_GRIN;
    private BigDecimal GRIN;
    private BigDecimal LOCKED_GRIN;


    private Bit2c.entities.results.Private.Balance.Fees Fees;




}
