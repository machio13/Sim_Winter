package simwinter.sample;

import java.math.BigDecimal;
import java.util.Map;

public class MarketData {
    private Map<String, BigDecimal> priceMap;
    private Map<String, String> marketNameMap;

    public MarketData(Map<String, BigDecimal> priceMap, Map<String, String> marketNameMap) {
        this.priceMap = priceMap;
        this.marketNameMap = marketNameMap;
    }

    public Map<String, BigDecimal> getPriceMap() {
        return priceMap;
    }

    public Map<String, String> getMarketNameMap() {
        return marketNameMap;
    }
}
