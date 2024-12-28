package simwinter.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class NeoMarketPriceReader {


    public static Map<String, BigDecimal> marketPriceMap(File neoFile) {
        Map<String, BigDecimal> priceMap = new HashMap<>();

        String line = "";
        String lineSplit = ",";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(neoFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("ticker")) {
                    continue;
                }
                String[] data = line.split(lineSplit);
                String ticker = data[0];
                BigDecimal price = new BigDecimal(data[1]);

                priceMap.put(ticker, price);
            }
        } catch (IOException e) {
            System.out.println("ファイルが正常に読み込めませんでした。");
        }
        return priceMap;
    }

    public static Map<String, String> marketName(File neoFile) {
        Map<String, String> marketMap = new HashMap<>();

        String line = "";
        String lineSplit = ",";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(neoFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("ticker")) {
                    continue;
                }
                String[] data = line.split(lineSplit);
                String ticker = data[0];
                String name = data[2];

                marketMap.put(ticker, name);
            }
        } catch (IOException e) {
            System.out.println("ファイルが正常に読み込めませんでした。");
        }
        return marketMap;
    }
}
