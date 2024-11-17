package NewSimSummer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketCsvReader {

    public static List<Stockers> readMarketCsv(File marketFile) {
        List<Stockers> stockersList = new ArrayList<>();
        String lineSplit = ",";
        String line = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(marketFile))){
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] wordBox = line.split(lineSplit);

                ExchangeMarket updateMarket = ExchangeMarket.isRename(wordBox[2]);
                BigDecimal updateSharesIssued = new BigDecimal(wordBox[3]);

                stockersList.add(new Stockers(wordBox[0], wordBox[1], updateMarket, updateSharesIssued));
            }
        }catch (IOException e) {
            System.out.println("ファイルが正常に読み込めない。");
        }catch (NumberFormatException e) {
            System.out.println("ファイル内の数値に異常があります。");
        }
        return stockersList;
    }
}
