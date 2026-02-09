package com.project.reportcardmanagement.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Student model class
 */
public class Student {

    private String studentId;
    private String studentName;
    private LocalDate dob;      // Use LocalDate for better date handling
    private String gender;
    private String email;
    private String className;

    // Constructors
    public Student() {}

    public Student(String studentId, String studentName, LocalDate dob, String gender, String email, String className) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.className = className;
    }

    // Getters & Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) {
        if(studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.studentName = studentName;
    }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}