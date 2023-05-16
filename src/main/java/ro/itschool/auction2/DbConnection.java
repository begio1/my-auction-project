package ro.itschool.auction2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/auction_db1";

    public static final String USERNAME = "root1";

    public static final String PASS = "1234";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASS)){
            System.out.println("Connection succeeded!");
        }catch (SQLException e){
            System.out.println("ERROR" +e.getMessage());
        }
    }
}
