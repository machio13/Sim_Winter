package simwinter;

import simwinter.master.MasterCsvReader;
import simwinter.master.Stock;

import java.io.File;
import java.util.List;

public class Checker {

    public static boolean isNameCheck (File marketFile, String name) {
        List<Stock> stockersList = MasterCsvReader.readMarketCsv(marketFile);
        for (Stock stock : stockersList) {
            if (stock.getName().equals(name)) {
                System.out.println(stock.getName());
                return true;
            }
        }
        return false;
    }

    public static boolean isTickerCheck (File marketFile, String ticker) {
        List<Stock> stockersList = MasterCsvReader.readMarketCsv(marketFile);
        for (Stock stock : stockersList) {
            if (stock.getTicker().equals(ticker)) {
                return true;
            }
        }
        return false;
    }
}
