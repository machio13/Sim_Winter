package NewSimSummer;

import java.math.BigDecimal;
import java.util.List;

public class MarketCsvDisplay extends Formater{

    public void shouMarket(List<Stockers> stockersList) {
        System.out.println("|===========================================================================|");
        System.out.println("| Ticker | Name                               | Market   | SharesIssued     |");
        System.out.println("|--------+------------------------------------+----------+------------------|");

        for (Stockers stockers : stockersList) {
            String ticker = stockers.getTicker();
            String name = isCutName(stockers.getName());
            ExchangeMarket market = stockers.getMarket();
            String sharesIssued = isBigDecimalFormat(stockers.getSharesIssued());

            System.out.printf("|  %-6s| %-34s | %-8s | %16s |\n", ticker, name, market, sharesIssued);
        }
        System.out.println("|===========================================================================|");
    }

    @Override
    int cutNum() {
        return 34;
    }
}
