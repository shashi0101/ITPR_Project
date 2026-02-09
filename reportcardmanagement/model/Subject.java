package com.project.reportcardmanagement.model;

import java.util.Objects;

public class Subject {

    private String subjectCode;
    private String subjectName;
    private int maxMarks;
    private int minMarks;

    public Subject() {}

    public Subject(String subjectCode, String subjectName, int maxMarks, int minMarks) {
        setSubjectCode(subjectCode);
        setSubjectName(subjectName);
        setMaxMarks(maxMarks);
        setMinMarks(minMarks);
    }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) {
        if(subjectCode == null || subjectCode.trim().isEmpty())
            throw new IllegalArgumentException("Subject code cannot be empty");
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) {
        if(subjectName == null || subjectName.trim().isEmpty())
            throw new IllegalArgumentException("Subject name cannot be empty");
        this.subjectName = subjectName;
    }

    public int getMaxMarks() { return maxMarks; }
    public void setMaxMarks(int maxMarks) {
        if(maxMarks < 0)
            throw new IllegalArgumentException("Max marks cannot be negative");
        if(minMarks > maxMarks)
            throw new IllegalArgumentException("Max marks cannot be less than min marks");
        this.maxMarks = maxMarks;
    }

    public int getMinMarks() { return minMarks; }
    public void setMinMarks(int minMarks) {
        if(minMarks < 0)
            throw new IllegalArgumentException("Min marks cannot be negative");
        if(maxMarks < minMarks)
            throw new IllegalArgumentException("Min marks cannot be greater than max marks");
        this.minMarks = minMarks;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", maxMarks=" + maxMarks +
                ", minMarks=" + minMarks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectCode, subject.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode);
    }
}