package modal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB1 {

    private static Connection connection;

    private static void setConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop", "root", "@ISURU9829ip");
        }
    }

    public static Integer IUD(String q) throws ClassNotFoundException, SQLException {
        setConnection();
        return connection.createStatement().executeUpdate(q);
    }

    public static ResultSet search(String q) throws ClassNotFoundException, SQLException {
        setConnection();
        return connection.createStatement().executeQuery(q);
    }

    public static void closeConnection() throws SQLException {
        connection.commit();
    }
}
