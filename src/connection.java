/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Dell
 */
public class connection {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        try {
      

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","123456789");
        } catch (SQLException e) {
            throw new SQLException("Failed to connect to database.");
        }

        return connection;
    }


}
