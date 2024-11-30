package simwinter;

import simwinter.trade.Trade;

import java.math.BigDecimal;
import java.util.List;

public class PositionNewDisplay {
    //実現損益＝売却数量＊(売却価格ー取得単価)
    //買い付け後の平均取得単価＝（買い付け前の保有数量＊平均取得単価＋買い付けた数量＊取得単価）/ 買い付け前の保有数量＋取得単価
//        保有するポジションを平均取得単価で価値算出したものを取得価額
//        取得価額＝保有数量＊平均取得価格

//        時価と保有数量を掛け合わせることで、「仮にこの金融商品をすぐに時価で売却したときに得られる金額」が得られる。これを評価結果とする方法が「時価を用いた評価」である。
//        評価額＝保有数量＊時価

//        評価額と取得価額の差額を評価損益または未実現損益という。
//        評価損益＝評価額ー取得価額


    public void allShowPosition(List<Position> positionList) {
        System.out.println("|========================================================================================================================================================|");
        System.out.println("| Ticker | Name                          | Quantity        | Average Unit Price | Realized Profit And Loss | Valuation      | Unrealized Profit And Loss |");
        System.out.println("|--------------------------------------------------------------------------------------------------------------------------------------------------------|");

        for (Position position : positionList) {
            String ticker = position.getTicker();
            String name = position.getName();
            long quantity = position.getQuantity();
            BigDecimal average = position.getAverageUnitPrice();
            BigDecimal realize = position.getRealizedProfitAndLoss();
            BigDecimal valuation = position.getValuation();
            BigDecimal une = position.getUnrealizedProfitAndLoss();
            System.out.printf("| %s | %s | %s | %s | %s | %s | %s |", ticker, name, quantity, average, realize, valuation, une);
        }
    }
}
