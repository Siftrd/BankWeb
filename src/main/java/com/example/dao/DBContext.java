package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bank";
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            return null;
        } catch(SQLException e) {
            return null;
        }
    }
}
