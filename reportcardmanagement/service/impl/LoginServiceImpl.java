package com.project.reportcardmanagement.service.impl;

import com.project.reportcardmanagement.dao.LoginDAO;
import com.project.reportcardmanagement.dao.impl.LoginDAOImpl;
import com.project.reportcardmanagement.model.Login;
import com.project.reportcardmanagement.service.LoginService;

/**
 * Implementation of LoginService
 */
public class LoginServiceImpl implements LoginService {

    private LoginDAO loginDAO;

    /**
     * Constructor initializes DAO
     */
    public LoginServiceImpl() {
        // Directly initialize DAO (no SQLException to catch)
        this.loginDAO = new LoginDAOImpl();
    }

    @Override
    public Login validateLogin(String username, String password) {
        // Validation check
        if(username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty");
        }

        // Delegate to DAO
        return loginDAO.validateLogin(username, password);
    }
}