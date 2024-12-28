//package simwinter.trade.remake;
//
//import simwinter.trade.Trade;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class NewTradeReader {
//
//    public static List<Trade> tradeReader(File tradeFile) {
//        List<Trade> tradeList = new ArrayList<>();
//
//        String line = "";
//        String lineSplit = ",";
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(tradeFile))) {
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] wordData = line.split(lineSplit);
//
//
//            }
//        }catch (IOException e) {
//            System.out.println("正常に読み込むことができませんでした。");
//        }
//    }
//}
