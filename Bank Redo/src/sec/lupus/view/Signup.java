package sec.lupus.view;

import sec.lupus.defaults.RoundedButtons;
import sec.lupus.defaults.RoundedTextField;

import javax.swing.*;

public class Signup {
    private JLabel userLabel;
    private RoundedTextField username;
    private JLabel emailLabel;
    private RoundedTextField email;
    private JLabel phoneLabel;
    private RoundedTextField phone;
    private RoundedButtons submit;
    private RoundedButtons cancel;

    public static void main(String[] args) {
        launch();
    }
    private void instantiateComponents() {
        userLabel = new JLabel("UserName");
        username = new RoundedTextField();
        emailLabel = new JLabel("Email");
        email = new RoundedTextField();
        phoneLabel = new JLabel("Phone");
        phone = new RoundedTextField();
        submit = new RoundedButtons();
        cancel = new RoundedButtons();
    }
    private void prepFrame() {
        instantiateComponents();

        Home.getPanel().add(username);
        Home.getPanel().add(email);
        Home.getPanel().add(phone);
        Home.getPanel().add(submit);
        Home.getPanel().add(cancel);
    }

    public static void launch() {
        new Signup().prepFrame();
    }
}
