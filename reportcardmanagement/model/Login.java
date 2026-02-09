package com.project.reportcardmanagement.model;

import java.util.Objects;

/**
 * Login model class
 * Represents a user login in the Report Card Management System
 */
public class Login {

    private String username;
    private String password;    // Add password for authentication
    private String role;        // ADMIN / TEACHER / STUDENT
    private Integer studentId;  // Null for ADMIN / TEACHER

    // Constructor for all fields
    public Login(String username, String password, String role, Integer studentId) {
        if(username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if(role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }

        this.username = username;
        this.password = password;
        this.role = role.toUpperCase();
        this.studentId = studentId;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        this.role = role.toUpperCase();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    // Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Login)) return false;
        Login login = (Login) o;
        return username.equals(login.username) &&
                role.equals(login.role) &&
                Objects.equals(studentId, login.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role, studentId);
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}