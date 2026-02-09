package com.project.reportcardmanagement;

import java.util.Scanner;

import com.project.reportcardmanagement.controller.AttendanceController;
import com.project.reportcardmanagement.controller.ExamController;
import com.project.reportcardmanagement.controller.LoginController;
import com.project.reportcardmanagement.controller.MarksController;
import com.project.reportcardmanagement.controller.ReportCardController;
import com.project.reportcardmanagement.controller.ScheduleController;
import com.project.reportcardmanagement.controller.StudentController;
import com.project.reportcardmanagement.controller.SubjectController;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== Controllers =====
        LoginController loginController = new LoginController();
        StudentController studentController = new StudentController();
        SubjectController subjectController = new SubjectController();
        MarksController marksController = new MarksController();
        AttendanceController attendanceController = new AttendanceController();
        ExamController examController = new ExamController();
        ScheduleController scheduleController = new ScheduleController();
        ReportCardController reportCardController = new ReportCardController();

        // ===== LOGIN FIRST =====
        boolean isLoggedIn = loginController.login();

        if (!isLoggedIn) {
            System.out.println("❌ Login Failed. Application Closed.");
            sc.close();
            return;
        }

        // ===== MAIN MENU =====
        while (true) {

            System.out.println("\n=================================");
            System.out.println(" REPORT CARD MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Student Management");
            System.out.println("2. Subject Management");
            System.out.println("3. Marks Management");
            System.out.println("4. Attendance Management");
            System.out.println("5. Exam Management");
            System.out.println("6. Schedule Management");
            System.out.println("7. Generate Report Card");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid input!");
                continue;
            }

            try {
                switch (choice) {

                    case 1:
                        studentController.menu();
                        break;

                    case 2:
                        subjectController.menu();
                        break;

                    case 3:
                        marksController.menu();
                        break;

                    case 4:
                        attendanceController.menu();
                        break;

                    case 5:
                        examController.menu();
                        break;

                    case 6:
                        scheduleController.menu();
                        break;

                    case 7:
                        reportCardController.menu();
                        break;

                    case 8:
                        System.out.println("✅ Thank you! Application closed.");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("❌ Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("⚠️ Error occurred!");
                e.printStackTrace();
            }
        }
    }
}