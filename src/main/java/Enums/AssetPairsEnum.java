package Enums;



public final class AssetPairsEnum {
    public enum AssetPairs {

        BtcNis("BtcNis", "XBT/USD", "currency", "XXBT", "currency", "ZUSD", "unit", "ZUSD", 1, 8, 1, 80, 40);



   String altName;

        String wsName;

        String aClassBase;

        String aClassQuote;

        String base;

        String quote;

        String lot;

        String feeVolCurrency;

        int pairDecimal;

        int lotDecimal;

        int lotMultiplier;

        int marginCall;

        int marginStop;

        AssetPairs(String altName, String wsName, String aClassBase, String aClassQuote, String quote,
                   String lot, String base, String feeVolCurrency, int pairDecimal, int lotDecimal,
                   int lotMultiplier, int marginCall, int marginStop) {
            this.altName = altName;
            this.wsName = wsName;
            this.aClassBase = aClassBase;
            this.aClassQuote = aClassQuote;
            this.quote = quote;
            this.lot = lot;
            this.base = base;
            this.feeVolCurrency = feeVolCurrency;
            this.pairDecimal = pairDecimal;
            this.lotDecimal = lotDecimal;
            this.lotMultiplier = lotMultiplier;
            this.marginCall = marginCall;
            this.marginStop = marginStop;
        }
    }
}
