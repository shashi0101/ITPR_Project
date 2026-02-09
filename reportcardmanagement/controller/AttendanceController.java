package com.project.reportcardmanagement.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.project.reportcardmanagement.model.Attendance;
import com.project.reportcardmanagement.service.AttendanceService;
import com.project.reportcardmanagement.service.impl.AttendanceServiceImpl;

public class AttendanceController {

    private AttendanceService service = new AttendanceServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        while (true) {
            try {
                System.out.println("\n--- ATTENDANCE MANAGEMENT ---");
                System.out.println("1. Mark Attendance");
                System.out.println("2. View Attendance by Student");
                System.out.println("3. Back");
                System.out.print("Choose option: ");

                int choice = Integer.parseInt(sc.nextLine().trim());

                switch (choice) {
                    case 1:
                        markAttendance();
                        break;
                    case 2:
                        viewAttendance();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid option! Choose 1, 2, or 3.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void markAttendance() {
        try {
            Attendance a = new Attendance();

            System.out.print("Enter Student ID: ");
            a.setStudentId(sc.nextLine().trim());

            System.out.print("Enter Date (YYYY-MM-DD): ");
            String dateStr = sc.nextLine().trim();
            LocalDate date = LocalDate.parse(dateStr); // Exception if invalid format
            a.setAttendanceDate(date);

            System.out.print("Status (P=Present / A=Absent): ");
            String status = sc.nextLine().trim().toUpperCase();
            if (!status.equals("P") && !status.equals("A")) {
                System.out.println("Invalid status! Enter only P or A");
                return;
            }
            a.setStatus(status);

            System.out.print("Remarks: ");
            a.setRemarks(sc.nextLine().trim());

            boolean success = service.addAttendance(a);
            if (success) {
                System.out.println("Attendance marked successfully!");
            } else {
                System.out.println("Failed to mark attendance!");
            }

        } catch (Exception e) {
            System.out.println("Error marking attendance: " + e.getMessage());
        }
    }

    private void viewAttendance() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine().trim();

            List<Attendance> list = service.getAttendanceByStudent(studentId);

            if (list.isEmpty()) {
                System.out.println("No attendance records found!");
                return;
            }

            System.out.println("\nDate        | Status | Remarks");
            System.out.println("---------------------------------");

            for (Attendance a : list) {
                System.out.printf("%-12s %-6s %s\n",
                        a.getAttendanceDate(),
                        a.getStatus(),
                        a.getRemarks());
            }

            // Show attendance percentage
            int total = service.getTotalDays(studentId);
            int present = service.getPresentDays(studentId);
            double percentage = total > 0 ? (present * 100.0 / total) : 0;
            System.out.printf("Total Classes: %d, Present: %d, Attendance %%: %.2f%%\n",
                    total, present, percentage);

        } catch (Exception e) {
            System.out.println("Error viewing attendance: " + e.getMessage());
        }
    }
}