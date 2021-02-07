package sec.lupus.defaults;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.logging.Logger;


public interface Default {
    String URL = "jdbc:postgresql://localhost/bank";
    String USR = "lupus";
    String PASSWD = "1234";
    Logger LOGGER = Logger.getLogger("Bank");

    default void setMouseListener(RoundedButtons buttons, Color fgEntered, Color fgExited) {
        buttons.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttons.setForeground(fgEntered);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttons.setForeground(fgExited);
            }
        });
    }
    default String getTime() {
        Date date = new Date();
        return date.toString();
    }
}
