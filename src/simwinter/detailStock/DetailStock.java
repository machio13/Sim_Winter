package simwinter.detailStock;

import simwinter.master.Market;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetailStock {
    private LocalDateTime tradedDateTime; //取引時間
    private String ticker;
    private String name;
    private Market market;
    private BigDecimal sharesIssued;
    private LocalDateTime inputDateTime; //入力時間
    private long quantity; //保有数量
    private BigDecimal averageUnitPrice; //平均取得単価
    private BigDecimal realizedProfitAndLoss; //実現損益

    public DetailStock(LocalDateTime tradedDateTime, String ticker, String name, Market market, BigDecimal sharesIssued, LocalDateTime inputDateTime, long quantity, BigDecimal averageUnitPrice, BigDecimal realizedProfitAndLoss) {
        this.tradedDateTime = tradedDateTime;
        this.ticker = ticker;
        this.name = name;
        this.market = market;
        this.sharesIssued = sharesIssued;
        this.inputDateTime = inputDateTime;
        this.quantity = quantity;
        this.averageUnitPrice = averageUnitPrice;
        this.realizedProfitAndLoss = realizedProfitAndLoss;
    }

    public LocalDateTime getTradedDateTime() {
        return tradedDateTime;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    public Market getMarket() {
        return market;
    }

    public BigDecimal getSharesIssued() {
        return sharesIssued;
    }

    public LocalDateTime getInputDateTime() {
        return inputDateTime;
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
}
