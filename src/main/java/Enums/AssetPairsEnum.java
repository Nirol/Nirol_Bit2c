package Enums;



public final class AssetPairsEnum {
    public enum AssetPairs {

        BtcNis("BTC"),
        LtcNis("LTC"),
        EthNis("ETH"),
        BchabcNis("BCHABC"),
        GrinNis("GRIN");



        public String coinName;



        AssetPairs(String coinName) {
            this.coinName = coinName;

        }
    }
}
