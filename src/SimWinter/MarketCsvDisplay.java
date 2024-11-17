package SimWinter;

import java.util.List;



public class MarketCsvDisplay extends CutName{

    public void shouMarket(List<Stock> stockersList) {
        System.out.println("|===========================================================================|");
        System.out.println("| Ticker | Name                               | Market   | SharesIssued     |");
        System.out.println("|--------+------------------------------------+----------+------------------|");

        for (Stock stock : stockersList) {
            String ticker = stock.getTicker();
            String name = isCutName(stock.getName());
            Market market = stock.getMarket();
            String sharesIssued = Formater.isBigDecimalFormat(stock.getSharesIssued());

            System.out.printf("|  %-6s| %-34s | %-8s | %16s |\n", ticker, name, market, sharesIssued);
        }
        System.out.println("|===========================================================================|");
    }

    @Override
    int cutNum() {
        return 34;
    }
}
