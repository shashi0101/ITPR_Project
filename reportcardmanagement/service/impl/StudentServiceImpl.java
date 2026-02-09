package com.project.reportcardmanagement.service.impl;

import java.util.List;

import com.project.reportcardmanagement.dao.StudentDAO;
import com.project.reportcardmanagement.dao.impl.StudentDAOImpl;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    // Constructor injection (optional)
    public StudentServiceImpl() {
        this.studentDAO = new StudentDAOImpl();
    }

    @Override
    public boolean addStudent(Student s) throws Exception {
        validateStudent(s);
        return studentDAO.addStudent(s);  // throws Exception handled by controller
    }

    @Override
    public boolean updateStudent(Student s) throws Exception {
        validateStudent(s);
        return studentDAO.updateStudent(s);  // throws Exception handled by controller
    }

    @Override
    public boolean deleteStudent(String studentId) throws Exception {
        if(studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        return studentDAO.deleteStudent(studentId);
    }

    @Override
    public Student getStudentById(String studentId) throws Exception {
        if(studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        return studentDAO.getStudentById(studentId);
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentDAO.getAllStudents();
    }

    // ------------------- VALIDATION -------------------
    private void validateStudent(Student s) {
        if(s == null)
            throw new IllegalArgumentException("Student cannot be null");

        if(s.getStudentId() == null || s.getStudentId().trim().isEmpty())
            throw new IllegalArgumentException("Student ID cannot be empty");

        if(s.getStudentName() == null || s.getStudentName().trim().isEmpty())
            throw new IllegalArgumentException("Student name cannot be empty");

        if(s.getEmail() == null || s.getEmail().trim().isEmpty())
            throw new IllegalArgumentException("Email cannot be empty");

        if(s.getClassName() == null || s.getClassName().trim().isEmpty())
            throw new IllegalArgumentException("Class cannot be empty");

        // Optional: Validate gender
        if(s.getGender() == null || !(s.getGender().equalsIgnoreCase("Male") 
                || s.getGender().equalsIgnoreCase("Female"))) {
            throw new IllegalArgumentException("Gender must be Male or Female");
        }

        // Optional: Validate DOB format (dd-mm-yyyy)
        if(s.getDob() == null) {
            throw new IllegalArgumentException("DOB must be in dd-mm-yyyy format");
        }
    }
}