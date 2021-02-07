package test.animation;

import javax.swing.*;
import java.util.TimerTask;
import java.util.logging.Logger;

class Helper extends TimerTask {
    public static int i = 0;
    private static final Logger LOGGER = Logger.getLogger(Helper.class.getName());
    public void run() {
        LOGGER.info("Timer ran %i"+ ++i);
    }
}

public class TypeAnime {
    TypeAnime() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

}
