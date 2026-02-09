package com.project.reportcardmanagement.controller;

import java.util.Scanner;

import com.project.reportcardmanagement.model.Login;
import com.project.reportcardmanagement.service.LoginService;
import com.project.reportcardmanagement.service.impl.LoginServiceImpl;

public class LoginController {

    private LoginService loginService = new LoginServiceImpl();
    private Scanner sc = new Scanner(System.in);

    // ===== LOGIN METHOD =====
    public boolean login() {

        System.out.println("\n==============================");
        System.out.println("        LOGIN MODULE          ");
        System.out.println("==============================");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        Login login = loginService.validateLogin(username, password);

        if (login != null) {
            System.out.println("✅ Login Successful! Welcome " + username);
            return true;
        } else {
            System.out.println("❌ Invalid Username or Password!");
            return false;
        }
    }
}