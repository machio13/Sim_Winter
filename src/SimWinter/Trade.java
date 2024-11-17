package SimWinter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {
    private LocalDateTime tradedDatetime;
    private String tradeName;
    private String tradeSide;
    private long tradeQuantity;
    private BigDecimal tradedUnitPrice;
    private LocalDateTime inputDatetime;

    public Trade(LocalDateTime tradedDatetime, String tradeName, String tradeSide, long tradeQuantity, BigDecimal tradedUnitPrice, LocalDateTime inputDatetime) {
        this.tradedDatetime = tradedDatetime;
        this.tradeName = tradeName;
        this.tradeSide = tradeSide;
        this.tradeQuantity = tradeQuantity;
        this.tradedUnitPrice = tradedUnitPrice;
        this.inputDatetime = inputDatetime;
    }

    public LocalDateTime getTradedDatetime() {
        return tradedDatetime;
    }

    public void setTradedDatetime(LocalDateTime tradedDatetime) {
        this.tradedDatetime = tradedDatetime;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeSide() {
        return tradeSide;
    }

    public void setTradeSide(String tradeSide) {
        this.tradeSide = tradeSide;
    }

    public long getTradeQuantity() {
        return tradeQuantity;
    }

    public void setTradeQuantity(long tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }

    public BigDecimal getTradedUnitPrice() {
        return tradedUnitPrice;
    }

    public void setTradedUnitPrice(BigDecimal tradedUnitPrice) {
        this.tradedUnitPrice = tradedUnitPrice;
    }

    public LocalDateTime getInputDatetime() {
        return inputDatetime;
    }

    public void setInputDatetime(LocalDateTime inputDatetime) {
        this.inputDatetime = inputDatetime;
    }
}
