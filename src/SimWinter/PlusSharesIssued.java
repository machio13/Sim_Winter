package SimWinter;

import java.math.BigDecimal;
import java.util.Scanner;

public class PlusSharesIssued {

    public BigDecimal addSharesIssued() {
        Scanner scanner = new Scanner(System.in);
        String userInputStr = "";
        BigDecimal userInput = null;
        boolean check = true;
        while (check) {
            System.out.print("発行済み株式数>");
            userInputStr = scanner.nextLine();
            try {
                if (userInputStr.length() < 13) {
                    userInput = new BigDecimal(userInputStr);
                    check = false;
                }else {
                    System.out.println("12字以内で書き直してください。");
                }
            }catch (NumberFormatException e) {
                System.out.println("数字を入力してください。");
            }
        }
        return userInput;
    }
}
