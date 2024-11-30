package simwinter;

public class MarketPrice {
    private String ticker;
    private double marketPrice;

    public MarketPrice(String ticker, double marketPrice) {
        this.ticker = ticker;
        this.marketPrice = marketPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public double getMarketPrice() {
        return marketPrice;
    }
}
