package SimWinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PlusMarketWriter {

    public void writeMarket(File marketFile) {
        PlusTicker plusTicker = new PlusTicker();
        PlusName plusName = new PlusName();
        PlusMarket plusMarket = new PlusMarket();
        PlusSharesIssued plusSharesIssued = new PlusSharesIssued();

        Stock stock = new Stock(plusTicker.addTicker(marketFile), plusName.addName(marketFile), plusMarket.addMarket(), plusSharesIssued.addSharesIssued());

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(marketFile, true))) {
            bufferedWriter.write(stock.getTicker() + "," + stock.getName() + "," + stock.getMarket().getFirstChar() + "," + stock.getSharesIssued());
            bufferedWriter.newLine();

        }catch (IOException e) {
            System.out.println("ファイルが正常に読み込めませんでした。");
        }
    }
}
