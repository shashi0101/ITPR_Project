package com.project.reportcardmanagement.dao;

import com.project.reportcardmanagement.model.Student;
import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student s) throws Exception;
    boolean updateStudent(Student s) throws Exception;
    boolean deleteStudent(String studentId) throws Exception;
    Student getStudentById(String studentId) throws Exception;
    List<Student> getAllStudents() throws Exception;
}