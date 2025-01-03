package simwinter.position;

import simwinter.trade.Trade;
import simwinter.trade.TradeSide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PositionInput {

    public static List<Position> sumPosition(List<Trade> tradeList) {
        List<Position> positionList = new ArrayList<>();

        for (Trade trade : tradeList) {
            boolean check = false;
            for (Position position : positionList) {
                if (position.getTicker().equals(trade.getTradeTicker())) {
                    check = true;
                    if (trade.getTradeSide().equals(TradeSide.Buy)) {
                        position.setPlusQuantity(trade.getTradeQuantity());
                    } else {
                        position.setMinusQuantity(trade.getTradeQuantity());
                    }
                }
            }
            if (!check) {
                long initialQuantity = trade.getTradeSide().equals(TradeSide.Buy) ? trade.getTradeQuantity() : -trade.getTradeQuantity();
                Position position = new Position(trade.getTradeName(), trade.getTradeTicker(), initialQuantity);
                positionList.add(position);
            }
        }
        Collections.sort(positionList, Comparator.comparing(Position::getTicker));
        return positionList;
    }
}
