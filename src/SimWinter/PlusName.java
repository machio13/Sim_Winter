package SimWinter;

import java.io.File;
import java.util.Scanner;

public class PlusName extends Checker{

    public String addName(File marketFile) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        boolean check = true;

        while (check) {
            System.out.print("銘柄名>");
            userInput = scanner.nextLine();
            if (isNameCheck(marketFile, userInput)) {
                System.out.println("既に記入済み");
            }
            if (userInput.matches("[a-zA-Z0-9 .()]*")) {
                check = false;
            }else {
                System.out.println("使えない文字があります。やり直し。");
            }
        }
        return userInput;
    }
}
