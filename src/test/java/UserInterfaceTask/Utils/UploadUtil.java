package UserInterfaceTask.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UploadUtil {
    public static void uploadFile() {

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        int milliSeconds = 1000;

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(milliSeconds);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(milliSeconds);

    }

}