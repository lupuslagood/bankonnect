package sec.lupus.control;

import sec.lupus.model.AccountLogin;
import sec.lupus.model.TransactionLogs;
import sec.lupus.view.Home;

public class Account {
    private static final TransactionLogs TRANSACTION_LOGS = new TransactionLogs();

    private Account() {}

    public static boolean loginSuccess() {
        System.out.println("login succcess" + new AccountLogin().accountLogin(Home.getAccountNumber().getText(), Home.getPasswordField().getPassword()));
        return new AccountLogin().accountLogin(Home.getAccountNumber().getText(), Home.getPasswordField().getPassword());
    }
    public static void newAccount() {

    }

    public static void saveLogin(String accountNumber) {
        TRANSACTION_LOGS.saveLogs(accountNumber);
    }

    public static String getTransactionLogs() {
        return TRANSACTION_LOGS.getTransactionLogs(Home.getAccountNumber().getText());
    }

    public static void logout() {
        TRANSACTION_LOGS.saveLogout(Home.getAccountNumber().getText());
    }

}
