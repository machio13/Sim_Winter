package simwinter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Position {
    private LocalDateTime tradedDatetime;
    private String name;
    private String ticker;
    private long quantity; //保有数量
    private BigDecimal averageUnitPrice; //平均取得単価
    private BigDecimal realizedProfitAndLoss; //実現損益
    private BigDecimal valuation; //評価額
    private BigDecimal unrealizedProfitAndLoss; //評価損益

    public Position(String name, String ticker,long quantity) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
    }

    public Position(String ticker, String name, long quantity, BigDecimal averageUnitPrice, BigDecimal realizedProfitAndLoss, BigDecimal valuation, BigDecimal unrealizedProfitAndLoss) {
        this.ticker = ticker;
        this.name = name;
        this.quantity = quantity;
        this.averageUnitPrice = averageUnitPrice;
        this.realizedProfitAndLoss = realizedProfitAndLoss;
        this.valuation = valuation;
        this.unrealizedProfitAndLoss = unrealizedProfitAndLoss;
    }

    public LocalDateTime getTradedDatetime() {
        return tradedDatetime;
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

    public void minusQuantity(long quantity) {
        this.quantity -= quantity;
    }
}
