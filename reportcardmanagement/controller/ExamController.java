package com.project.reportcardmanagement.controller;

import java.util.Scanner;

import com.project.reportcardmanagement.model.Exam;
import com.project.reportcardmanagement.service.ExamService;
import com.project.reportcardmanagement.service.impl.ExamServiceImpl;

public class ExamController {

    private ExamService examService = new ExamServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n===== EXAM MANAGEMENT =====");
            System.out.println("1. Add Exam Details");
            System.out.println("2. View Exam by Student ID");
            System.out.println("3. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addExam(); break;
                case 2: viewExamByStudent(); break;
                case 3: return;
                default: System.out.println("Invalid option!"); break;
            }
        }
    }

    private void addExam() {
        try {
            Exam exam = new Exam();

            System.out.print("Enter Student ID: ");
            exam.setStudentId(sc.nextLine());

            System.out.print("Enter Exam Type (Mid/Final): ");
            exam.setExamType(sc.nextLine());

            System.out.print("Is Eligible (Yes/No): ");
            exam.setIsEligible(sc.nextLine());

            System.out.print("Enter Exam Date (YYYY-MM-DD): ");
            exam.setExamDate(sc.nextLine());

            if (examService.addExam(exam)) {
                System.out.println("✓ Exam details added successfully!");
            } else {
                System.out.println("✗ Failed to add exam details!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewExamByStudent() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();

            Exam exam = examService.getExamByStudentId(studentId);
            if (exam != null) {
                System.out.println("\n--- Exam Details ---");
                System.out.println("Student ID : " + exam.getStudentId());
                System.out.println("Exam Type  : " + exam.getExamType());
                System.out.println("Eligible   : " + exam.getIsEligible());
                System.out.println("Exam Date  : " + exam.getExamDate());
            } else {
                System.out.println("✗ No exam record found for this student.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}