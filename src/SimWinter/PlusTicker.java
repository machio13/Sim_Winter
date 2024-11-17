package SimWinter;

import java.io.File;
import java.util.Scanner;

public class PlusTicker extends Checker {

    public String addTicker(File marketFile) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean check = true;

        while (check) {
            System.out.print("銘柄コード>");
            userInput = scanner.nextLine();
            if (isTickerCheck(marketFile, userInput)) {
                System.out.println("同じ銘柄コードが既に記入済み。");
            }
            if (userInput.matches("^\\d{4}$|^[0-9][0-9ACDFGHJKLMNPRSTUWXY][0-9][0-9ACDFGHJKLMNPRSTUWXY]")) {
                check = false;
            }else {
                System.out.println("正しく入力し直してください。");
            }
        }
        return userInput;
    }
}
