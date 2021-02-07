package test;
import java.util.logging.Logger;
import java.sql.*;
public class Test {
    private static final Logger LOGGER  = Logger.getLogger(Test.class.getName());
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/bank";
        String user = "lupus";
        String password = "1234";
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            LOGGER.info("Works!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}