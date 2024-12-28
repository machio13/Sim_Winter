package simwinter.detailStock;

import simwinter.master.Market;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class DetailStockDisplay {

    public static void display(List<DetailStock> detailStockList) {
        System.out.println("|====================================================================================================================|");

        for (DetailStock detailStock : detailStockList) {
            LocalDateTime tradedDatetime = detailStock.getTradedDateTime();
            String ticker = detailStock.getTicker();
            String name = detailStock.getName();;
            Market market = detailStock.getMarket();
            BigDecimal sharesIssued = detailStock.getSharesIssued();
            LocalDateTime inputTime = detailStock.getInputDateTime();
            long quantity = detailStock.getQuantity();
            BigDecimal averageUnitPrice = detailStock.getAverageUnitPrice();
            BigDecimal realizePnL = detailStock.getRealizedProfitAndLoss();

            System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n", tradedDatetime, ticker, name, market, sharesIssued, inputTime, quantity, averageUnitPrice, realizePnL);
        }
        System.out.println("|====================================================================================================================|");
    }
}
