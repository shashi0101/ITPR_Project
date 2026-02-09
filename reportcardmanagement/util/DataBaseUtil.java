package com.project.reportcardmanagement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/reportcarddb";
    private static final String USER = "root";
    private static final String PASSWORD = "shifaparveen@786";

   public static Connection getConnection() {
	   Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return con;
    }
}