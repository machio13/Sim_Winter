package simwinter;

import simwinter.trade.Trade;
import simwinter.trade.TradeSide;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PositionNewInput {

    public static List<Position> newPosition(List<Trade> tradeList, List<MarketPrice> marketPriceList) {
        List<Position> positionList = new ArrayList<>();

        BigDecimal averageUnitPrice = null;
        BigDecimal realizeProfitAndLoss = null;
        BigDecimal valuation = null;
        BigDecimal unrealizedProfitAndLoss = null;


        for (Trade trade : tradeList) {
            for (MarketPrice marketPrice : marketPriceList) {
                boolean check = false;
                for (Position position : positionList) {

                    if (position.getTicker().equals(trade.getTradeTicker())) {
                        check = true;

                        if (trade.getTradeSide().equals(TradeSide.Buy)) {
                            String averagePriceStr = String.valueOf(position.getAverageUnitPrice());
                            long longAverageUnitPrice = Long.parseLong(averagePriceStr);

                            String tradeUP = String.valueOf(trade.getTradedUnitPrice());
                            long tradeUnitPrice = Long.parseLong(tradeUP);

                            long average = ((position.getQuantity() * longAverageUnitPrice) + (trade.getTradeQuantity() * tradeUnitPrice)) / position.getQuantity() + trade.getTradeQuantity();
                            BigDecimal averageBig = new BigDecimal(average);
                            position.addAverage(averageBig);
                            position.addQuantity(trade.getTradeQuantity());

                        } else {
                            String tradeUnitPriceStr = String.valueOf(trade.getTradedUnitPrice());
                            long tradeUnitPrice = Long.parseLong(tradeUnitPriceStr);
                            if (position.getTicker().equals(marketPrice.getTicker())) {
                                double realize = trade.getTradeQuantity() * (marketPrice.getMarketPrice() - tradeUnitPrice);
                                BigDecimal realizeProfitAndLossBig = new BigDecimal(realize);
                                position.addRealizedProfitAndLoss(realizeProfitAndLossBig);

                                double valuationLong = tradeUnitPrice * marketPrice.getMarketPrice();
                                BigDecimal valuationBig = new BigDecimal(valuationLong);
                                position.addValuation(valuationBig);
                                position.minusQuantity(trade.getTradeQuantity());
                            }
                        }
                    }
                }
                if (!check) {
                    long initialQuantity = trade.getTradeSide().equals(TradeSide.Buy) ? trade.getTradeQuantity() : -trade.getTradeQuantity();
                    averageUnitPrice = trade.getTradedUnitPrice();
                    String averageUnitPriceStr = String.valueOf(averageUnitPrice);
                    long averageUnitPriceLong = Long.parseLong(averageUnitPriceStr);
                    realizeProfitAndLoss = BigDecimal.ZERO;
                    double valuationLong = marketPrice.getMarketPrice() * trade.getTradeQuantity();
                    valuation = new BigDecimal(valuationLong);
                    long acquisitionCost = averageUnitPriceLong * trade.getTradeQuantity();
                    double unrealizedProfitAndLossLong = valuationLong - acquisitionCost;
                    unrealizedProfitAndLoss = new BigDecimal(unrealizedProfitAndLossLong);

                    Position position = new Position(trade.getTradeTicker(), trade.getTradeName(), initialQuantity, averageUnitPrice, realizeProfitAndLoss, valuation, unrealizedProfitAndLoss);
                    positionList.add(position);
                }
            }
        }
        Collections.sort(positionList, Comparator.comparing(Position::getTicker));
        return positionList;
    }
}
