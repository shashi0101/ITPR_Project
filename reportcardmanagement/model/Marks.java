package com.project.reportcardmanagement.model;

public class Marks {

    private String studentId;
    private String subjectCode;
    private String subjectName;
    private int marks;
    private int maxMarks;
    private int minMarks;

    // ------------------ Constructors ------------------

    public Marks() {}

    public Marks(String studentId, String subjectCode, String subjectName, int marks, int maxMarks, int minMarks) {
        this.studentId = studentId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
        this.minMarks = minMarks;
        setMarks(marks);  // ensures validation
    }

    // ------------------ Getters & Setters ------------------

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if(marks < 0) {
            throw new IllegalArgumentException("Marks cannot be negative");
        }
        if(maxMarks > 0 && marks > maxMarks) {
            throw new IllegalArgumentException("Marks cannot exceed maximum marks (" + maxMarks + ")");
        }
        this.marks = marks;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public int getMinMarks() {
        return minMarks;
    }

    public void setMinMarks(int minMarks) {
        this.minMarks = minMarks;
    }

    // ------------------ Utility ------------------
    @Override
    public String toString() {
        return "Marks [studentId=" + studentId +
                ", subjectCode=" + subjectCode +
                ", subjectName=" + subjectName +
                ", marks=" + marks +
                ", maxMarks=" + maxMarks +
                ", minMarks=" + minMarks + "]";
    }
}