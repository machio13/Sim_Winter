package SimWinter;

import java.io.File;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TradeValidation {
    Scanner scanner = new Scanner(System.in);

    public LocalDateTime addTradeTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd/HH:mm").withResolverStyle(ResolverStyle.STRICT);
        String userInputStr = "";
        LocalDateTime userInput = null;
        LocalDateTime today = LocalDateTime.now();
        boolean check = true;
        while (check){
            System.out.print("取引日時(yyyy-MM-dd/HH:mm)>");
            userInputStr = scanner.nextLine();
            try{
                userInput = LocalDateTime.parse(userInputStr, formatter);
                DayOfWeek dayOfWeek = userInput.getDayOfWeek();
                if (userInput.isBefore(today) || userInput.equals(today)) {
                    switch (dayOfWeek) {
                        case SATURDAY, SUNDAY -> {
                            System.out.println("土日で時間外");
                        }
                        default -> {
                            if (userInput.getHour() >= 9 && userInput.getHour() <= 14) {
                                check = false;
                            } else if (userInput.getHour() == 15 && userInput.getMinute() <= 30) {
                                check = false;
                            } else {
                                System.out.println("平日ですが時間外です。");
                                check = true;
                            }
                        }
                    }
                }else {
                    System.out.println("日付が未来になっています。");
                }
            }catch (DateTimeParseException e) {
                System.out.println("フォーマット通り記入し直して");
            }
        }
        return userInput;
    }

    public String addName(File marketFile) {
        boolean check = true;
        String userInput = "";
        while (check) {
            System.out.print("銘柄名>");
            userInput = scanner.nextLine();
            if (isNameCheck(marketFile, userInput)) {
                System.out.println("正常な入力です");
                check = false;
            }else {
                System.out.println("記入されている銘柄名が見つかりません。");
            }
        }
        return userInput;
    }

    public String addSide() {
        String userInput = "";
        boolean check = true;
        while (check) {
            System.out.print("売買区分(Sell or Buy)>");
            userInput = scanner.nextLine();
            if (userInput.equals("Sell") || userInput.equals("Buy")) {
                check = false;
            }else {
                System.out.println("正しく記入し直してください。");
            }
        }return userInput;
    }

    public long addQuantity() {
        String userInputStr = "";
        long userInput = 0;
        boolean check = true;
        while (check) {
            System.out.print("数量(100株単位)>");
            userInputStr = scanner.nextLine();
            try {
                userInput = Long.parseLong(userInputStr);
                if (userInput % 100 == 0) {
                    check = false;
                }else {
                    System.out.println("100株単位で入力してください");
                }
            }catch (NumberFormatException e) {
                System.out.println("数字を入力してください。");
            }
        }
        return userInput;
    }

    public BigDecimal addUnitPrice() {
        String userInputStr = "";
        BigDecimal userInput = null;
        boolean check = true;
        while (check) {
            System.out.print("取引単価(小数第二位まで可能)>");
            userInputStr = scanner.nextLine();
            try {
                BigDecimal bigDecimal = new BigDecimal(userInputStr);
                userInput = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_DOWN);
                check = false;
            }catch (NumberFormatException e) {
                System.out.println("数字を入力してください。");
            }
        }
        return userInput;
    }

    public LocalDateTime addInputDatetime() {
        LocalDateTime today = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        System.out.println("入力日時；" + today);
        System.out.println("ーーー入力完了ーーー");
        return today;
    }


}

