package simwinter.detailStock;


import simwinter.Checks;
import simwinter.master.Market;
import simwinter.master.Stock;
import simwinter.position.Position;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DetailStockInput {

    public static List<DetailStock> findStock(File tradeFile, List<Stock> stockList, List<Position> positionList) {
        List<DetailStock> detailStockList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean check = true;
        while (check) {
            System.out.print("銘柄コードを選択してください:");
            String userInput = scanner.nextLine();
            for (Stock stock : stockList) {
                if (stock.getTicker().equals(userInput)) {
                    for (Position position : positionList) {
                        if (position.getTicker().equals(userInput)) {
                            System.out.println("保有情報を表示します。");
                            LocalDateTime maxTradeTime = Checks.tradedDatetimeCheck(userInput, tradeFile);
                            String ticker = position.getTicker();
                            String name = position.getName();
                            Market market = stock.getMarket();
                            BigDecimal sharesIssued = stock.getSharesIssued();
                            LocalDateTime maxInputTime = Checks.inputDateTimeCheck(userInput, tradeFile);
                            long quantity = Checks.quantityMap(positionList, userInput);
                            BigDecimal averageUnitPrice = Checks.averageUnitPriceMap(positionList, userInput);
                            BigDecimal realizedPnL = Checks.realizedPnLMap(positionList, userInput);

                            detailStockList.add(new DetailStock(maxTradeTime, ticker, name, market, sharesIssued, maxInputTime, quantity, averageUnitPrice, realizedPnL));
                            check = false;

                        }
                    }
                }
            }
        }
        return detailStockList;
    }
}
