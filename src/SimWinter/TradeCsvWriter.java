package SimWinter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TradeCsvWriter {
    public void writeTrade(File martketFile, File tradeFile) {
        ValHalfUp valHalfUp = new ValHalfUp();
        ValHalfDown valHalfDown = new ValHalfDown();

        Trade trade = new Trade(valHalfUp.addTradeTime(), valHalfUp.addName(martketFile), valHalfDown.addSide()
                    , valHalfDown.addQuantity(), valHalfDown.addUnitPrice(), valHalfDown.addInputDatetime());

            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tradeFile, true))) {
                bufferedWriter.write(trade.getTradedDatetime() + "," + trade.getTradeName()
                        + "," + trade.getTradeSide() + "," + trade.getTradeQuantity()
                        + "," + trade.getTradedUnitPrice() + "," + trade.getInputDatetime());
                bufferedWriter.newLine();

            }catch (IOException e) {
                System.out.println("ファイルに正常に書き込めませんでした。");
            }
        }
    }

}
