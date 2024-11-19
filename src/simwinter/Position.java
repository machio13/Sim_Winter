package simwinter;

import java.math.BigDecimal;

public class Position {
    private String name;
    private String ticker;
    private long quantity;
    private BigDecimal averageUnitPrice;
    private BigDecimal realizedProfitAndLoss;
    private BigDecimal valuation;
    private BigDecimal unrealizedProfitAndLoss;

    public Position(String name, String ticker,long quantity) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
    }

    public Position(String name, String ticker, long quantity, BigDecimal averageUnitPrice, BigDecimal realizedProfitAndLoss, BigDecimal valuation, BigDecimal unrealizedProfitAndLoss) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
        this.averageUnitPrice = averageUnitPrice;
        this.realizedProfitAndLoss = realizedProfitAndLoss;
        this.valuation = valuation;
        this.unrealizedProfitAndLoss = unrealizedProfitAndLoss;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public long getQuantity() {
        return quantity;
    }

    public BigDecimal getAverageUnitPrice() {
        return averageUnitPrice;
    }

    public BigDecimal getRealizedProfitAndLoss() {
        return realizedProfitAndLoss;
    }

    public BigDecimal getValuation() {
        return valuation;
    }

    public BigDecimal getUnrealizedProfitAndLoss() {
        return unrealizedProfitAndLoss;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }
}
