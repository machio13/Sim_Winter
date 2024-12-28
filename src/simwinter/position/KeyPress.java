package simwinter.position;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyPress {

    public static void pressControlAndS() {
        try {
            // Robot クラスのインスタンスを生成
            Robot robot = new Robot();

            // Controlキーを押す
            robot.keyPress(KeyEvent.VK_META);

            // Sキーを押す
            robot.keyPress(KeyEvent.VK_S);

            // Sキーを離す
            robot.keyRelease(KeyEvent.VK_S);

            // Controlキーを離す
            robot.keyRelease(KeyEvent.VK_META);

            System.out.println("コントロールとSを押しました。");
        } catch (Exception e) {
            System.err.println("エラーにより押せませんでした。");
            e.printStackTrace();
        }
    }
}
