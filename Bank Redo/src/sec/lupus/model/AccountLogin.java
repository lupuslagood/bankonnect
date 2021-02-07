package sec.lupus.model;

import sec.lupus.control.Account;
import sec.lupus.defaults.Default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountLogin implements Default {
    private PreparedStatement prep;
    private ResultSet resultSet;
    private String sql;
    private  String accountName;

    public static String getAccountName() {
        return new AccountLogin().accountName;
    }
    private void setAccountName(String accountName) {
        new AccountLogin().accountName = accountName;
    }

    public boolean accountLogin(String account, char[] password) {
        boolean success = false;
        StringBuilder strPassword = new StringBuilder();
        for (char c : password) {
            strPassword.append(c);
        }
        if (isAuthentic(account, strPassword.toString())) {
            success = true;
            Account.saveLogin(account);
        }
        return success;
    }

    private  boolean isExist(String account) {
        boolean exists = false;
        try(Connection connection = DriverManager.getConnection(URL, USR, PASSWD)) {
            String dbAccount = "";
            sql = "SELECT * FROM accounts WHERE account_number = ? ;";
            prep = connection.prepareStatement(sql);
            prep.setString(1, account);
            resultSet = prep.executeQuery();
            while (resultSet.next()) {
                dbAccount = resultSet.getString("account_number");
                setAccountName(resultSet.getString("account_name"));
            }
            if (!dbAccount.equals(""))
                exists = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  exists;
    }
    private boolean isAuthentic(String account, String password) {
        boolean isAuthentic = false;
        if (isExist(account)) {
            try (Connection connection = DriverManager.getConnection(URL, USR, PASSWD)) {
                String dbPassword = "";
                sql = "SELECT password FROM accounts WHERE account_number = ? ;";
                prep = connection.prepareStatement(sql);
                prep.setString(1, account);
                resultSet = prep.executeQuery();
                while (resultSet.next()) {
                    dbPassword = resultSet.getString("password");
                }
                if (dbPassword.equals(password)) {
                    isAuthentic = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isAuthentic;
    }
}
