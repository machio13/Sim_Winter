package SimWinter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TradeCsvReader {

    public static List<Trade> readTradeCsv(File tradeFile) {
        List<Trade> tradeList = new ArrayList<>();

        String lineSplit = ",";
        String line = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(tradeFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] wordBox = line.split(lineSplit);
                LocalDateTime replaceTDTime = LocalDateTime.parse(wordBox[0]);
                long replaceQuantity = Long.parseLong(wordBox[3]);
                BigDecimal replaceUnitPrice = new BigDecimal(wordBox[4]);
                LocalDateTime replaceInputDatetime = LocalDateTime.parse(wordBox[5]);

                tradeList.add(new Trade(replaceTDTime, wordBox[1], wordBox[2], replaceQuantity, replaceUnitPrice, replaceInputDatetime));
            }
        }catch (IOException e) {
            System.out.println("ファイルが正常に読み込めません。");
        }
        Collections.sort(tradeList, Comparator.comparing(Trade::getInputDatetime));
        return tradeList;
    }
}
