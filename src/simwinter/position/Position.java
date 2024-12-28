package simwinter.position;

import java.math.BigDecimal;

public class Position {
    private String name;
    private String ticker;
    private long quantity; //保有数量
    private BigDecimal averageUnitPrice; //平均取得単価
    private BigDecimal realizedProfitAndLoss; //実現損益

    public Position(String name, String ticker,long quantity) {
        this.name = name;
        this.ticker = ticker;
        this.quantity = quantity;
    }

    public Position(String ticker, String name, long quantity, BigDecimal averageUnitPrice, BigDecimal realizedProfitAndLoss) {
        this.ticker = ticker;
        this.name = name;
        this.quantity = quantity;
        this.averageUnitPrice = averageUnitPrice;
        this.realizedProfitAndLoss = realizedProfitAndLoss;
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

    public void setPlusQuantity(long quantity) {
        this.quantity += quantity;
    }

    public void setMinusQuantity(long quantity) {
        this.quantity -= quantity;
    }

    public void setAverageUnitPrice(BigDecimal averageUnitPrice) {
        this.averageUnitPrice = averageUnitPrice;
    }

    public void setRealizedProfitAndLoss(BigDecimal realizedProfitAndLoss) {
        this.realizedProfitAndLoss = realizedProfitAndLoss;
    }
}
