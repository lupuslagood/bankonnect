package sec.lupus.view;

import javax.swing.JLabel;
import java.awt.Color;

public class Services {
    JLabel service = new JLabel("Banking Services....");
    public Services() {
        service.setForeground(Color.white);
        service.setBounds(20, 30, 130, 22);
        Home.getPanelMain().add(service);
        Home.getPanelMain().repaint();
    }
}
