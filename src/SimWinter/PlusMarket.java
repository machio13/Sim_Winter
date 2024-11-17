package SimWinter;

import java.util.Scanner;

public class PlusMarket {

    public Market addMarket() {
        Scanner scanner = new Scanner(System.in);
        Market userInput = null;
        String userInputStr = "";
        boolean check = true;
        while (check) {
            System.out.print("上場市場(Prime:P, Standard:S, Growth:G)>");
            userInputStr = scanner.nextLine();
            switch (userInputStr) {
                case "P" -> {
                    userInput = Market.Prime;
                    check = false;
                }
                case "S" -> {
                    userInput = Market.Standard;
                    check = false;
                }
                case "G" -> {
                    userInput = Market.Growth;
                    check = false;
                }
                default -> {
                    System.out.println("記入が正しくありません。やり直し。");
                    check = true;
                }
            }
        }
        return userInput;
    }
}
