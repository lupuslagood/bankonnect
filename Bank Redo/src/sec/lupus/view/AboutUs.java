package sec.lupus.view;
import javax.swing.JLabel;
import java.awt.Color;

public class AboutUs {
    private JLabel about = new JLabel("This is  a bankonnector...");
    public AboutUs() {
        about.setForeground(Color.white);
        about.setBounds(30, 50, 120, 22);
        Home.getPanelMain().add(about);
        Home.getPanelMain().repaint();
    }
}
