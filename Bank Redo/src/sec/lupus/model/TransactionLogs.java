package sec.lupus.model;

import sec.lupus.defaults.Default;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

class ErrorLogger {
    private ErrorLogger() {}
    public static void logError(String error) {
        try(Writer fw = new FileWriter("logs.txt", true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter fout = new PrintWriter(bw)){
            fout.println(error);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }

public class TransactionLogs implements Default {
    private String transactionType;
    private Connection connect;
    private PreparedStatement prep;
    String sql;

    public void saveLogs(String accountNumber){
        transactionType = "LOGIN";

        try {
            connect = DriverManager.getConnection(URL, USR, PASSWD);
            sql = "INSERT INTO logs(account_number, transaction_type, time) VALUES(?,?,?)";
            prep = connect.prepareStatement(sql);
            prep.setString(1, accountNumber);
            prep.setString(2, transactionType);
            prep.setString(3, this.getTime());
            prep.executeUpdate();
        } catch (Exception e) {

            ErrorLogger.logError(e.getMessage());
            System.exit(1);
        } finally {
            try {
                connect.close();
                prep.close();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
                ErrorLogger.logError(e.getMessage());
            }
        }
    }
    public String getTransactionLogs(String accountNumber){
        sql = "SELECT * FROM logs WHERE account_number = ?";

        StringBuilder log = new StringBuilder();
        try {
            connect = DriverManager.getConnection(URL, USR, PASSWD);
            prep = connect.prepareStatement(sql);
            prep.setString(1, accountNumber);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                log.append(rs.getString("account_number")).append("    ");
                log.append(rs.getString("transaction_type")).append("    ");
                if (rs.getString("recepient_account") != null) {
                    log.append(rs.getString("recepient_account")).append("    ");
                }
                log.append(rs.getString("time")).append("\n");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            ErrorLogger.logError(e.getMessage());
            System.exit(1);
        }
        return log.toString();
    }

    public void  saveLogout(String accountNumber) {
        transactionType = "LOGOUT";
        sql = "INSERT INTO logs(account_number, transaction_type, time) VALUES (?,?,?)";
        try {
            connect = DriverManager.getConnection(URL, USR, PASSWD);
            prep = connect.prepareStatement(sql);
            prep.setString(1, accountNumber);
            prep.setString(2,transactionType);
            prep.setString(3, getTime());
            prep.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            ErrorLogger.logError(e.getMessage());
            System.exit(1);
        } finally {
            try {
                connect.close();
                prep.close();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
                ErrorLogger.logError(e.getMessage());
                System.exit(1);
            }
        }
    }
}
