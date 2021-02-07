package sec.lupus.view;

import sec.lupus.control.Account;
import sec.lupus.defaults.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home implements Default {
    private static JFrame frame;
    private static RoundedPanel panelMain;
    private static JPanel panel;
    private static RoundedTextField accountNumber;
    private JLabel accountLabel;
    private JLabel passwordLabel;
    private static RoundedPasswordField passwordField;
    private RoundedButtons login;
    private JLabel noAccount;
    private RoundedButtons signup;
    private static final JLabel error = new JLabel();
    private RoundedButtons homeButton;
    private RoundedButtons servicesButton;
    private RoundedButtons aboutButton;
    private RoundedButtons exitButton;

    public static JPanel getPanel() {
        return panel;
    }

    private static void setPanel(JPanel panel) {
        Home.panel = panel;
    }

    public RoundedButtons getExitButton() {
        return exitButton;
    }

    public void setExitButton(RoundedButtons exitButton) {
        this.exitButton = exitButton;
    }

    public RoundedButtons getHomeButton() {
        return homeButton;
    }

    public void setHomeButton(RoundedButtons homeButton) {
        this.homeButton = homeButton;
    }

    public RoundedButtons getServicesButton() {
        return servicesButton;
    }

    public void setServicesButton(RoundedButtons servicesButton) {
        this.servicesButton = servicesButton;
    }

    public RoundedButtons getAboutButton() {
        return aboutButton;
    }

    public void setAboutButton(RoundedButtons aboutButton) {
        this.aboutButton = aboutButton;
    }


    public static JLabel getError() {
        return error;
    }

    public static void setPanelMain(RoundedPanel panelMain) {
        Home.panelMain = panelMain;
    }

    public void setAccountLabel(JLabel accountLabel) {
        this.accountLabel = accountLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public void setLogin(RoundedButtons login) {
        this.login = login;
    }

    public void setNoAccount(JLabel noAccount) {
        this.noAccount = noAccount;
    }

    public void setSignup(RoundedButtons signup) {
        this.signup = signup;
    }

    public static RoundedPanel getPanelMain() {
        return panelMain;
    }

    public JLabel getAccountLabel() {
        return accountLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public RoundedButtons getLogin() {
        return login;
    }

    public JLabel getNoAccount() {
        return noAccount;
    }

    public RoundedButtons getSignup() {
        return signup;
    }

    public static JFrame getFrame() {
        return frame;
    }
    private static void setFrame(JFrame frame) {
        Home.frame = frame;
    }

    public static RoundedTextField getAccountNumber() {
        return accountNumber;
    }
    private static void setAccountNumber(RoundedTextField accountNumber) {
        Home.accountNumber = accountNumber;
    }

    public static void setPasswordField(RoundedPasswordField passwordField) {
        Home.passwordField = passwordField;
    }

    public static RoundedPasswordField getPasswordField() {
        return passwordField;
    }
    
    public static void error(String errorMessage) {
        getError().setText(errorMessage);
        getError().setForeground(Color.red);
        getError().setFont(new Font("Comic Sans", Font.ITALIC, 12));
        getError().setBounds(210, 210, 250, 20);
        getPanelMain().revalidate();
    }

    private void displayHome() {
        Font labelFont = new Font("Comic sans", Font.BOLD, 18);

        setAccountLabel(new JLabel("Account"));
        getAccountLabel().setBounds(50, 60, 190, 20);
        getAccountLabel().setFont(labelFont);
        getAccountLabel().setForeground(Color.cyan);

        setAccountNumber(new RoundedTextField());
        getAccountNumber().setBounds(200, 50, 300, 40);

        setPasswordLabel(new JLabel("Password"));
        getPasswordLabel().setBounds(50, 180, 190, 20);
        getPasswordLabel().setFont(labelFont);
        getPasswordLabel().setForeground(Color.cyan);

        setPasswordField(new RoundedPasswordField());
        getPasswordField().setBounds(200, 170, 300, 40);

        setLogin(new RoundedButtons());
        getLogin().setText("Login");
        getLogin().setBounds(100, 330, 100, 50);
        getLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getLogin().setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getLogin().setForeground(Color.cyan);
            }
        });
        getLogin().addActionListener(e -> {
            System.out.println(Account.loginSuccess());
            if (Account.loginSuccess()) {
                getPanel().removeAll();
                System.out.println("panel components");
                getPanelMain().removeAll();
                System.out.println("mainpanel components");
                Profile.launch();
            } else
                error("Oops! Invalid account or password");
        });

        setNoAccount(new JLabel("Don't Have An Account Yet?"));
        getNoAccount().setFont(new Font("Comic Sans", Font.BOLD, 11));
        getNoAccount().setBounds(310, 290, 200, 50);
        getNoAccount().setForeground(new Color(0, 0, 255));
        getNoAccount().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getNoAccount().setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getNoAccount().setForeground(new Color(0, 0, 255));
            }
        });

        setSignup(new RoundedButtons());
        getSignup().setText("Signup");
        getSignup().setBounds(350, 330, 100, 50);
        getSignup().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getSignup().setForeground(Color.green);
                getNoAccount().setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getSignup().setForeground(Color.cyan);
                getNoAccount().setForeground(new Color(0, 0, 255));
            }
        });

        getSignup().addActionListener(e -> {
            getPanel().removeAll();
            getPanelMain().removeAll();
            Signup.launch();
        });

        getPanelMain().add(getAccountLabel());
        getPanelMain().add(getAccountNumber());
        getPanelMain().add(getPasswordLabel());
        getPanelMain().add(getPasswordField());
        getPanelMain().add(getLogin());
        getPanelMain().add(getNoAccount());
        getPanelMain().add(getSignup());
        getPanelMain().add(getError());

        getPanelMain().repaint();
    }
    private void addMainButtons() {
        setHomeButton(new RoundedButtons());
        getHomeButton().setText("Home");
        getHomeButton().setBounds(10, 150, 130, 50);
        getHomeButton().setEnabled(false);
        setMouseListener(getHomeButton(), Color.green, Color.cyan);
        getHomeButton().addActionListener(e -> {
            getPanelMain().removeAll();
            displayHome();
            enableButtons();
            getHomeButton().setEnabled(false);
        });

        setServicesButton(new RoundedButtons());
        getServicesButton().setText("Services");
        getServicesButton().setBounds(10, 250, 130, 50);
        setMouseListener(getServicesButton(), Color.green, Color.cyan);
        getServicesButton().addActionListener(e -> {
            getPanelMain().removeAll();
            new Services();
            enableButtons();
            getServicesButton().setEnabled(false);
        });

        setAboutButton(new RoundedButtons());
        getAboutButton().setText("About Us");
        getAboutButton().setBounds(10, 350, 130, 50);
        setMouseListener(getAboutButton(), Color.green, Color.cyan);
        getAboutButton().addActionListener(e -> {
            getPanelMain().removeAll();
            new AboutUs();
            enableButtons();
            getAboutButton().setEnabled(false);
        });

        setExitButton(new RoundedButtons());
        getExitButton().setText("Exit");
        getExitButton().setForeground(new Color(139, 0, 0));
        getExitButton().setBounds(10, 450, 130, 50);
        setMouseListener(getExitButton(), Color.red, new Color(139, 0, 0));
        getExitButton().addActionListener(e -> System.exit(0));

        setPanelMain(new RoundedPanel());

        displayHome();

        getPanel().add(getHomeButton());
        getPanel().add(getServicesButton());
        getPanel().add(getAboutButton());
        getPanel().add(getExitButton());
        getPanel().add(getPanelMain());
    }
    private void prepFrame() {
        setFrame(new JFrame("Bank"));
        getFrame().setBounds(300, 200, 1000, 700);
        getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getFrame().setUndecorated(true);
        getFrame().getContentPane().setLayout(null);
        
        setPanel(new JPanel());
        getPanel().setLayout(null);
        getPanel().setBounds(0,0,1000,700);
        getPanel().setBackground(new Color(0,10,50));
        getPanel().setDoubleBuffered(true);

        addMainButtons();

        getFrame().getContentPane().add(getPanel());

        getFrame().setVisible(true);
    }
    private void enableButtons() {
        getHomeButton().setEnabled(true);
        getServicesButton().setEnabled(true);
        getAboutButton().setEnabled(true);
    }

    public static void run() {
        new Home().addMainButtons();
        getFrame().setTitle("Bank");
        getPanel().revalidate();
        getPanel().repaint();
    }
    private void init() {
        prepFrame();
    }

    public static void main(String[] args) {
        new Home().init();
    }
}
