package sec.lupus.view;

import sec.lupus.control.Account;
import sec.lupus.defaults.*;
import sec.lupus.model.AccountLogin;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profile implements Default {
    private RoundedButtons transfer;
    private RoundedButtons transactionLogs;
    private RoundedButtons logout;
    private static final JLabel error = new JLabel();
    private String paymentOption;
    private static RoundedButtons mpesa;
    private static RoundedButtons paypal;
    private RoundedButtons bitcoin;
    private RoundedButtons anotherBank;
    private final Font font = new Font("Comic Sans", Font.BOLD, 18);
    private final JLabel from = new JLabel("From");
    private final RoundedButtons next = new RoundedButtons();
    private final RoundedButtons cancel = new RoundedButtons();
    private JTextArea logArea;

    public JTextArea getLogArea() {
        return logArea;
    }

    public void setLogArea(JTextArea logArea) {
        this.logArea = logArea;
    }

    public static JLabel getError() {
        return error;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public RoundedButtons getMpesa() {
        return mpesa;
    }

    public static void setMpesa(RoundedButtons mpesa) {
        Profile.mpesa = mpesa;
    }

    public RoundedButtons getPaypal() {
        return paypal;
    }

    public static void setPaypal(RoundedButtons paypal) {
        Profile.paypal = paypal;
    }

    public RoundedButtons getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(RoundedButtons bitcoin) {
        this.bitcoin = bitcoin;
    }

    public RoundedButtons getAnotherBank() {
        return anotherBank;
    }

    public void setAnotherBank(RoundedButtons anotherBank) {
        this.anotherBank = anotherBank;
    }
    
    public RoundedButtons getTransfer() {
        return transfer;
    }

    public void setTransfer(RoundedButtons transfer) {
        this.transfer = transfer;
    }

    public RoundedButtons getTransactionLogs() {
        return transactionLogs;
    }

    public void setTransactionLogs(RoundedButtons transactionLogs) {
        this.transactionLogs = transactionLogs;
    }

    public RoundedButtons getLogout() {
        return logout;
    }

    public void setLogout(RoundedButtons logout) {
        this.logout = logout;
    }

    private void mpesaTransfer() {
        JLabel phoneNumber = new JLabel("M-Pesa Account");
        phoneNumber.setBounds(20,60, 190, 20);
        phoneNumber.setFont(font);
        phoneNumber.setForeground(Color.cyan);
        Home.getPanelMain().add(phoneNumber);

        RoundedTextField phone = new RoundedTextField();
        phone.setBounds(200, 50, 300, 40);
        Home.getPanelMain().add(phone);

        JLabel pin = new JLabel("M-Pesa PIN");
        pin.setBounds(50, 175, 300, 40);
        pin.setFont(font);
        pin.setForeground(Color.cyan);
        Home.getPanelMain().add(pin);

        RoundedPasswordField pinNumber = new RoundedPasswordField();
        pinNumber.setBounds(200, 170, 300, 40);
        Home.getPanelMain().add(pinNumber);

        next.setText("Next");
        next.setFont(font);
        next.setBounds(400, 300, 100, 40);
        setMouseListener(next, Color.green, Color.cyan);
        next.addActionListener(e -> {
            Home.getPanelMain().removeAll();
            from.setText("To");
            showOptions();
        });
        Home.getPanelMain().add(next);

        cancel.setText("Cancel");
        cancel.setFont(font);
        cancel.setBounds(20, 300, 100, 40);
        cancel.addActionListener(e -> {
            Home.getPanelMain().removeAll();
            Home.getPanel().remove(Home.getPanelMain());
            enableButtons();
            Home.getPanel().repaint();
        });
        setMouseListener(cancel, Color.red, Color.cyan);
        Home.getPanelMain().add(cancel);
        Home.getPanelMain().repaint();
    }
    private void showOptions() {
        from.setForeground(Color.white);
        from.setBounds(10, 10, 100, 22);
        Home.getPanelMain().add(from);

        getMpesa().setText("M-Pesa");
        getMpesa().setBackground(Color.black);
        getMpesa().setForeground(Color.lightGray);
        getMpesa().setBounds(10, 50, 100, 50);
        getMpesa().addActionListener(e -> {
            Home.getPanelMain().removeAll();
            mpesaTransfer();
        });
        setMouseListener(getMpesa(), Color.green, Color.lightGray);
        Home.getPanelMain().add(getMpesa());

        getPaypal().setText("Paypal");
        getPaypal().setBackground(Color.black);
        getPaypal().setForeground(Color.lightGray);
        getPaypal().setBounds(150, 50, 100, 50);

        getPaypal().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getPaypal().setForeground(Color.white);
                getPaypal().setBackground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                getPaypal().setForeground(Color.lightGray);
                getPaypal().setBackground(Color.black);
            }
        });
        Home.getPanelMain().add(getPaypal());

        getBitcoin().setText("Bitcoin");
        getBitcoin().setBounds(300, 50, 100, 50);
        getBitcoin().setBackground(Color.black);
        getBitcoin().setForeground(Color.lightGray);
        setMouseListener(getBitcoin(), new Color(255, 215, 0), Color.lightGray);
        Home.getPanelMain().add(getBitcoin());

        getAnotherBank().setText("Bank");
        getAnotherBank().setForeground(Color.lightGray);
        getAnotherBank().setBounds(450,50,100,50);
        setMouseListener(getAnotherBank(), Color.cyan, Color.lightGray);
        Home.getPanelMain().add(getAnotherBank());

        Home.getPanel().add(Home.getPanelMain());
        Home.getPanel().repaint();
    }

    private void instantiateButtons() {
        setTransfer(new RoundedButtons());
        setTransactionLogs(new RoundedButtons());
        setMpesa(new RoundedButtons());
        setPaypal(new RoundedButtons());
        setBitcoin(new RoundedButtons());
        setAnotherBank(new RoundedButtons());
        setLogout(new RoundedButtons());
    }

    private void enableButtons() {
        getTransfer().setEnabled(true);
        getTransactionLogs().setEnabled(true);
        getLogout().setEnabled(true);
    }
    private void showLogs() {
        setLogArea(new JTextArea(50, 300));
        getLogArea().setBounds(240, 150, 800, 300);
        getLogArea().setEditable(false);
        getLogArea().setBackground(new Color(0,10,50));
        getLogArea().setForeground(Color.white);
        getLogArea().setFont(new Font("Comic Sans", Font.PLAIN, 22));
        JScrollPane scrollPane = new JScrollPane(getLogArea());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(240, 150, 800, 300);
        Home.getPanel().add(scrollPane);
    }

    private void addMainButtons() {

        instantiateButtons();

        getTransfer().setText("Send");
        getTransfer().setBounds(10, 150, 130, 50);
        getTransfer().addActionListener(e -> {
            Home.getPanel().removeAll();
            addMainButtons();
            enableButtons();
            getTransfer().setEnabled(false);
            showOptions();
        });
        setMouseListener(getTransfer(), Color.green, Color.cyan);
        Home.getPanel().add(getTransfer());

        getTransactionLogs().setText("Check Logs");
        getTransactionLogs().setBounds(10, 250, 130, 50);
        setMouseListener(getTransactionLogs(), Color.green, Color.cyan);
        getTransactionLogs().addActionListener(e -> {
            enableButtons();
            getTransactionLogs().setEnabled(false);
            Home.getPanel().remove(Home.getPanelMain());
            showLogs();
            getLogArea().append(Account.getTransactionLogs());
            Home.getPanel().repaint();
        });
        Home.getPanel().add(getTransactionLogs());

        getLogout().setText("Logout");
        getLogout().setBounds(10, 350, 130, 50);
        getLogout().setForeground(new Color(139, 0, 0));
        setMouseListener(getLogout(), Color.red, new Color(139, 0, 0));
        getLogout().addActionListener(e -> {
            Account.logout();
            Home.getPanel().removeAll();
            Home.run();
        });
        Home.getPanel().add(getLogout());
    }

    public void prepFrame() {
        addMainButtons();
    }

    public static void launch() {
        new Profile().prepFrame();
        Home.getFrame().setTitle(AccountLogin.getAccountName());
        Home.getPanel().revalidate();
        Home.getPanel().repaint();
    }

}

