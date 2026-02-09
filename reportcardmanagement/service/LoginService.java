package com.project.reportcardmanagement.service;

import com.project.reportcardmanagement.model.Login;

/**
 * Service interface for login operations
 */
public interface LoginService {
    /**
     * Validates login credentials
     * @param username the username
     * @param password the password
     * @return Login object if valid, else null
     */
    Login validateLogin(String username, String password);
}