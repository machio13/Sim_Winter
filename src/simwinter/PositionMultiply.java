package simwinter;

import simwinter.trade.Trade;
import simwinter.trade.TradeSide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PositionMultiply {

    public static List<Position> sumPosition(List<Trade> tradeList) {
        List<Position> positionList = new ArrayList<>();

        for (Trade trade : tradeList) {
            boolean check = false;
            for (Position position : positionList) {
                if (position.getTicker().equals(trade.getTradeTicker())) {
                    check = true;

                    if (trade.getTradeSide().equals(TradeSide.Buy)) {
                        position.addQuantity(trade.getTradeQuantity());
                    }else if (trade.getTradeSide().equals(TradeSide.Sell)){
                        position.addQuantity(-trade.getTradeQuantity());
                    }
                }
            }
            if (!check) {
                Position position = new Position(trade.getTradeName(), trade.getTradeTicker(), trade.getTradeQuantity());
                positionList.add(position);
            }
        }
        Collections.sort(positionList, Comparator.comparing(Position::getTicker));
        return positionList;
    }
}
