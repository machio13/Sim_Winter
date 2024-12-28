package simwinter.position;

import simwinter.trade.Trade;
import simwinter.trade.TradeSide;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class PositionNewInput {

    public static List<Position> newPosition(List<Trade> tradeList, List<MarketPrice> marketPriceList) {
        List<Position> positionList = new ArrayList<>();

        BigDecimal averageUnitPrice;
        BigDecimal realizeProfitAndLoss;

        for (Trade trade : tradeList) {
            boolean check = false;
            for (Position position : positionList) {
                if (position.getTicker().equals(trade.getTradeTicker())) {
                    check = true;
                    BigDecimal tradeUnitPrice = trade.getTradedUnitPrice();

                    if (trade.getTradeSide().equals(TradeSide.Buy)) {
                        BigDecimal averageUnitPrice2 = position.getAverageUnitPrice();
                        BigDecimal tradeUnitPrice2 = trade.getTradedUnitPrice();
                        BigDecimal positionQuantity = new BigDecimal(position.getQuantity());
                        BigDecimal tradeQuantity = new BigDecimal(trade.getTradeQuantity());

                        BigDecimal totalCost = positionQuantity.multiply(averageUnitPrice2).add(tradeQuantity.multiply(tradeUnitPrice2));
                        BigDecimal totalQuantity = positionQuantity.add(tradeQuantity);

                        position.setAverageUnitPrice(totalCost.divide(totalQuantity, 2, RoundingMode.HALF_DOWN)); //平均取得単価の変更
                        position.setPlusQuantity(trade.getTradeQuantity());//所有数量の変更

                    } else {
                        BigDecimal tradeQuantity = new BigDecimal(trade.getTradeQuantity()); //取引数量
                        BigDecimal positionAverageUnitPrice = position.getAverageUnitPrice(); //平均取得単価
                        BigDecimal element = tradeUnitPrice.subtract(positionAverageUnitPrice); //取引単価ー平均取得単価

                        position.setRealizedProfitAndLoss(tradeQuantity.multiply(element));//実現損益の変更
                        position.setMinusQuantity(trade.getTradeQuantity());//所有数量の変更
                    }
                }
            }
            if (!check) {
                long initialQuantity = trade.getTradeQuantity();
                realizeProfitAndLoss = BigDecimal.ZERO;
                averageUnitPrice = trade.getTradedUnitPrice();
                Position position = new Position(trade.getTradeTicker(), trade.getTradeName(), initialQuantity, averageUnitPrice, realizeProfitAndLoss);
                positionList.add(position);
            }
        }
        Collections.sort(positionList, Comparator.comparing(Position::getTicker));
        return positionList;
    }
}
