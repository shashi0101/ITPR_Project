package com.project.reportcardmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.project.reportcardmanagement.model.Schedule;
import com.project.reportcardmanagement.service.ScheduleService;
import com.project.reportcardmanagement.service.impl.ScheduleServiceImpl;

public class ScheduleController {

    private ScheduleService scheduleService = new ScheduleServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void menu() {

        while (true) {
            System.out.println("\n===== EXAM SCHEDULE MANAGEMENT =====");
            System.out.println("1. Add Exam Schedule");
            System.out.println("2. View Schedule By Exam Type");
            System.out.println("3. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // buffer clear

            switch (choice) {

            case 1:
                addSchedule();
                break;

            case 2:
                viewSchedule();
                break;

            case 3:
                return;

            default:
                System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }

    // ================= ADD SCHEDULE =================
    private void addSchedule() {

        try {
            Schedule s = new Schedule();

            System.out.print("Enter Exam Type (Mid / Final): ");
            s.setExamType(sc.nextLine());

            System.out.print("Enter Subject Code: ");
            s.setSubjectCode(sc.nextLine());

            System.out.print("Enter Exam Date (YYYY-MM-DD): ");
            s.setExamDate(sc.nextLine());   // ✅ String only

            System.out.print("Enter Start Time (HH:MM): ");
            s.setStartTime(sc.nextLine());  // ✅ String only

            System.out.print("Enter End Time (HH:MM): ");
            s.setEndTime(sc.nextLine());    // ✅ String only

            boolean status = scheduleService.addSchedule(s);

            if (status) {
                System.out.println("✅ Schedule added successfully!");
            } else {
                System.out.println("❌ Failed to add schedule.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error while adding schedule");
            e.printStackTrace();
        }
    }

    // ================= VIEW SCHEDULE =================
    private void viewSchedule() {

        try {
            System.out.print("Enter Exam Type (Mid / Final): ");
            String examType = sc.nextLine();

            List<Schedule> list = scheduleService.viewScheduleByExam(examType);

            if (list.isEmpty()) {
                System.out.println("❌ No schedule found!");
                return;
            }

            System.out.println("\n----- Exam Schedule -----");
            for (Schedule s : list) {
                System.out.println(
                        "Subject Code : " + s.getSubjectCode() +
                        " | Date : " + s.getExamDate() +
                        " | Time : " + s.getStartTime() + " - " + s.getEndTime()
                );
            }

        } catch (Exception e) {
            System.out.println("❌ Error while viewing schedule");
            e.printStackTrace();
        }
    }
}