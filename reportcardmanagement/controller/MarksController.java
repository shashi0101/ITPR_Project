package com.project.reportcardmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.project.reportcardmanagement.model.Marks;
import com.project.reportcardmanagement.service.MarksService;
import com.project.reportcardmanagement.service.impl.MarksServiceImpl;

public class MarksController {

    private MarksService marksService = new MarksServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n--- Marks Management ---");
            System.out.println("1. Add Marks");
            System.out.println("2. Update Marks");
            System.out.println("3. View Marks by Student");
            System.out.println("4. View All Marks");
            System.out.println("5. Delete Marks");
            System.out.println("6. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            try {
                switch (choice) {
                    case 1: addMarks(); break;
                    case 2: updateMarks(); break;
                    case 3: viewMarksByStudent(); break;
                    case 4: viewAllMarks(); break;
                    case 5: deleteMarks(); break;
                    case 6: return;
                    default: System.out.println("Invalid option!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ---------------- ADD MARKS ----------------
    private void addMarks() throws Exception {
        Marks m = new Marks();

        System.out.print("Enter Student ID: ");
        m.setStudentId(sc.nextLine());

        System.out.print("Enter Subject Code: ");
        m.setSubjectCode(sc.nextLine());

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        m.setMarks(marks);

        boolean result = marksService.addMarks(m);
        System.out.println(result ? "✔ Marks added successfully!" : "✗ Failed to add marks");
    }

    // ---------------- UPDATE MARKS ----------------
    private void updateMarks() throws Exception {
        Marks m = new Marks();

        System.out.print("Enter Student ID: ");
        m.setStudentId(sc.nextLine());

        System.out.print("Enter Subject Code: ");
        m.setSubjectCode(sc.nextLine());

        System.out.print("Enter New Marks: ");
        m.setMarks(sc.nextInt());
        sc.nextLine();

        boolean result = marksService.updateMarks(m);
        System.out.println(result ? "✔ Marks updated successfully!" : "✗ Update failed");
    }

    // ---------------- VIEW MARKS BY STUDENT ----------------
    private void viewMarksByStudent() throws Exception {
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        List<Marks> list = marksService.getMarksByStudent(studentId);

        if (list.isEmpty()) {
            System.out.println("No marks found!");
            return;
        }

        System.out.println("\nMarks for Student ID: " + studentId);
        printMarksTable(list);
    }

    // ---------------- VIEW ALL MARKS ----------------
    private void viewAllMarks() throws Exception {
        List<Marks> list = marksService.getAllMarks();

        if (list.isEmpty()) {
            System.out.println("No records found!");
            return;
        }

        System.out.println("\nAll Students Marks");
        printMarksTable(list);
    }

    // ---------------- DELETE MARKS ----------------
    private void deleteMarks() throws Exception {
        System.out.print("Enter Student ID: ");
        String studentId = sc.nextLine();

        System.out.print("Enter Subject Code: ");
        String subjectCode = sc.nextLine();

        boolean result = marksService.deleteMarks(studentId, subjectCode);
        System.out.println(result ? "✔ Marks deleted successfully!" : "✗ Delete failed");
    }

    // ---------------- TABLE PRINT UTILITY ----------------
    private void printMarksTable(List<Marks> list) {
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-10s %-12s %-20s %-6s %-6s %-6s%n",
                "StudentID", "SubCode", "Subject Name", "Marks", "Min", "Max");
        System.out.println("-----------------------------------------------------------");

        for (Marks m : list) {
            System.out.printf("%-10s %-12s %-20s %-6d %-6d %-6d%n",
                    m.getStudentId(),
                    m.getSubjectCode(),
                    m.getSubjectName() != null ? m.getSubjectName() : "-",
                    m.getMarks(),
                    m.getMinMarks(),
                    m.getMaxMarks());
        }
        System.out.println("-----------------------------------------------------------");
    }
}