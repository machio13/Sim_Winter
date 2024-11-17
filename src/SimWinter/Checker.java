package SimWinter;

import java.io.File;
import java.util.List;

public abstract class Checker {

    public boolean isNameCheck (File marketFile, String name) {
        List<Stock> stockersList = MarketCsvReader.readMarketCsv(marketFile);
        for (Stock stock : stockersList) {
            if (stock.getName().equals(name)) {
                System.out.println(stock.getName());
                return true;
            }
        }
        return false;
    }

    public boolean isTickerCheck (File marketFile, String ticker) {
        List<Stock> stockersList = MarketCsvReader.readMarketCsv(marketFile);
        for (Stock stock : stockersList) {
            if (stock.getTicker().equals(ticker)) {
                return true;
            }
        }
        return false;
    }
}
