package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static Connection conn;
    private static String url = "jdbc:mysql://localhost/test";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection(){
        if(conn == null){
            establishNewConnection();
        }
        return conn;

    }

    private static void establishNewConnection(){
        try{
            conn = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            System.out.println("Error establishing connection: \n" + e.getMessage());
        }
    }
}

//
//import java.sql.*;
//
//public class App {
//   public static void main(String[] args) {
//      try {
//         // Load the MySQL JDBC driver
//         Class.forName("com.mysql.cj.jdbc.Driver");
//
//         // Connect to the database
//         String url = "jdbc:mysql://localhost:3306/?user=root";
//     
//         Connection con = DriverManager.getConnection(url);
//
//         // Do something with the connection
//         // ...
//
//         // Close the connection
//         con.close();
//      }
//      catch (Exception e) {
//         System.err.println("Error: " + e.getMessage());
//      }
//   }
//}