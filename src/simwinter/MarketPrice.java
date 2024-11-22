package simwinter;

public class MarketPrice {
    private String ticker;
    private long marketPrice;

    public MarketPrice(String ticker, long marketPrice) {
        this.ticker = ticker;
        this.marketPrice = marketPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public long getMarketPrice() {
        return marketPrice;
    }
}
