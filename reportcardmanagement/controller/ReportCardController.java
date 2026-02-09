package com.project.reportcardmanagement.controller;

import java.util.Map;
import java.util.Scanner;

import com.project.reportcardmanagement.model.ReportCard;
import com.project.reportcardmanagement.service.ReportCardService;
import com.project.reportcardmanagement.service.impl.ReportCardServiceImpl;

public class ReportCardController {

    private Scanner sc = new Scanner(System.in);
    private ReportCardService reportCardService = new ReportCardServiceImpl();

    public void menu() {

        while (true) {
            System.out.println("\n===== REPORT CARD MANAGEMENT =====");
            System.out.println("1. Generate Report Card by Student ID");
            System.out.println("2. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    generateReportCard();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void generateReportCard() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();

            ReportCard reportCard = reportCardService.generateReportCard(studentId);

            if (reportCard == null) {
                System.out.println("❌ Student not found!");
                return;
            }

            // Display Report Card
            System.out.println("\n===== REPORT CARD =====");
            System.out.println("Student ID       : " + reportCard.getStudentId());
            System.out.println("Student Name     : " + reportCard.getStudentName());
            System.out.println("Class            : " + reportCard.getClassName());

            System.out.println("\n--- Marks ---");
            System.out.printf("%-25s %-10s\n", "Subject", "Marks");
            System.out.println("-------------------------------");
            for (Map.Entry<String, Integer> entry : reportCard.getMarksMap().entrySet()) {
                System.out.printf("%-25s %-10d\n", entry.getKey(), entry.getValue());
            }

            System.out.println("\nTotal Marks      : " + reportCard.getTotalMarks());
            System.out.printf("Marks Percentage : %.2f%%\n", reportCard.getMarksPercentage());
            System.out.printf("Attendance %%     : %.2f%%\n", reportCard.getAttendancePercentage());
            System.out.println("Result           : " + reportCard.getResult());

        } catch (Exception e) {
            System.out.println("Error generating report card: " + e.getMessage());
            e.printStackTrace();
        }
    }
}