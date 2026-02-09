package com.project.reportcardmanagement.dao;

import com.project.reportcardmanagement.model.Login;

/**
 * Interface for Login operations
 */
public interface LoginDAO {
    /**
     * Validates login credentials
     * @param username the username
     * @param password the password
     * @return Login object if valid, else null
     */
    Login validateLogin(String username, String password);
}