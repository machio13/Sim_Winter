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

        for (Trade trade : tradeList) {
            boolean check = false;
            for (Position position : positionList) {
                if (position.getTicker().equals(trade.getTradeTicker())) {
                    check = true;

                    if (trade.getTradeSide().equals(TradeSide.Buy)) {
                        String up = String.valueOf(position.getAverageUnitPrice());
                        long averageUnitPriceLong = Long.parseLong(up);

                        String tradeUP = String.valueOf(trade.getTradedUnitPrice());
                        long tradeUnitPrice = Long.parseLong(tradeUP);

                        long average = position.getQuantity() * averageUnitPriceLong + trade.getTradeQuantity() * tradeUnitPrice / position.getQuantity() + trade.getTradeQuantity();
                        averageUnitPrice = new BigDecimal(average);
                        position.addQuantity(trade.getTradeQuantity());

                    }else {

                        position.minusQuantity(trade.getTradeQuantity());
                    }
                }
            }
            if (!check) {
                long initialQuantity = trade.getTradeSide().equals(TradeSide.Buy)
                        ? trade.getTradeQuantity() : -trade.getTradeQuantity();
                Position position = new Position(trade.getTradeTicker(), trade.getTradeName(), initialQuantity, trade.getTradedUnitPrice(), averageUnitPrice, );
                positionList.add(position);
            }
        }
        Collections.sort(positionList, Comparator.comparing(Position::getTicker));
        return positionList;
    }
}
