package BL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public Connection database;
    public Connection getConnection() {
        String dbname = "project";
        String dbuser = "root";
        String dbpass = "123456";
        String url = "jdbc:mysql://localhost/" + dbname;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            database = DriverManager.getConnection(url,dbuser,dbpass); // database connection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return database;
    }
}
