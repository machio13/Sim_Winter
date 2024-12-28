package simwinter.sample;

import simwinter.position.Position;
import simwinter.trade.Trade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NeoMarketPriceDisplay {

//    public static void showDisplay(MarketData marketData) {
////         marketData.getPriceMap().forEach((key, value) -> System.out.println(key + " -> " + value));
//
//        marketData.getPriceMap().forEach((key, value) -> {
////            System.out.println(key);
//            String ticker = key;
//            BigDecimal price = value;
//
//            System.out.println(ticker);
//            System.out.println(price);
//        });
//         marketData.getMarketNameMap().forEach((key, value) -> System.out.println(key + "->" + value));
//    }

//    public static void showDisplay(List<ProStock> proStock) {
//         marketData.getPriceMap().forEach((key, value) -> System.out.println(key + " -> " + value));

//        marketData.getPriceMap().forEach((key, value) -> {
////            System.out.println(key);
//            String ticker = key;
//            BigDecimal price = value;
//
//            System.out.println(ticker);
//            System.out.println(price);
//        });
//        marketData.getMarketNameMap().forEach((key, value) -> System.out.println(key + "->" + value));
//    }

    public static Map<String, Trade> showDisplay(Map<String, BigDecimal> marketPriceMap, Map<String, String> marketNameMap, List<Trade> tradeList) {
        List<Position> positionList = new ArrayList<>();
        Map<String, Trade> tradeMap = tradeList.stream().collect(Collectors.toMap(Trade::getTradeTicker, mp -> mp));

        return tradeMap;
    }
}
