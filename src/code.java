
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public class code {
     // JDBC URL, username, and password of database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/biometric";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";

    public static void main(String[] args) {
        // SQL query to update data
        String sqlUpdate = "UPDATE biometric.all " +
                           "SET Remark_in = 'check' " +
                           "WHERE time_out > '18:15:00' AND time_in = time_out";

        try (
            // Establish connection to database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
            // Create a statement from the connection
            PreparedStatement statement = connection.prepareStatement(sqlUpdate);
        ) {
            // Execute the update statement
            int rowsUpdated = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            e.printStackTrace();
        }
}}
