package com.adtu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection connection ;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/socialsphere","root","pass@123");
            System.out.println("Connection Established.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
