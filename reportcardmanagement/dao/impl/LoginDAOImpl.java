package com.project.reportcardmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.reportcardmanagement.dao.LoginDAO;
import com.project.reportcardmanagement.model.Login;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class LoginDAOImpl implements LoginDAO {

    private static final String LOGIN_QUERY =
            "SELECT username, role, student_id FROM login WHERE username = ? AND password = ?";

    @Override
    public Login validateLogin(String username, String password) {
        if(username == null || password == null) {
            throw new IllegalArgumentException("Username or Password cannot be null");
        }

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(LOGIN_QUERY)) {

            ps.setString(1, username);
            ps.setString(2, password); // Ideally password should be hashed

            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    String role = rs.getString("role");
                    Integer studentId = rs.getObject("student_id") != null ? rs.getInt("student_id") : null;

                    // Return Login object
                    return new Login(username, password, role, studentId);
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error during login validation: " + e.getMessage());
            e.printStackTrace();
        }

        // Return null if login failed
        return null;
    }
}