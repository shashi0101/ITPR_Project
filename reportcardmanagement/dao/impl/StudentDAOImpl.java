package com.project.reportcardmanagement.dao.impl;

import com.project.reportcardmanagement.dao.StudentDAO;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.util.DataBaseUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private static final String TABLE = "student";

    // Utility to map ResultSet to Student object
    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        return new Student(
                rs.getString("student_id"),
                rs.getString("student_name"),
                rs.getDate("dob") != null ? rs.getDate("dob").toLocalDate() : null,
                rs.getString("gender"),
                rs.getString("email"),
                rs.getString("class")
        );
    }

    @Override
    public boolean addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (student_id, student_name, dob, gender, email, class) VALUES (?,?,?,?,?,?)";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getStudentId());
            ps.setString(2, s.getStudentName());
            ps.setDate(3, s.getDob() != null ? Date.valueOf(s.getDob()) : null);
            ps.setString(4, s.getGender());
            ps.setString(5, s.getEmail());
            ps.setString(6, s.getClassName());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateStudent(Student s) throws SQLException {
        String sql = "UPDATE " + TABLE + " SET student_name=?, dob=?, gender=?, email=?, class=? WHERE student_id=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getStudentName());
            ps.setDate(2, s.getDob() != null ? Date.valueOf(s.getDob()) : null);
            ps.setString(3, s.getGender());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getClassName());
            ps.setString(6, s.getStudentId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteStudent(String studentId) throws SQLException {
        String sql = "DELETE FROM " + TABLE + " WHERE student_id=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentId);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Student getStudentById(String studentId) throws SQLException {
        String sql = "SELECT * FROM " + TABLE + " WHERE student_id=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToStudent(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE;

        try (Connection conn = DataBaseUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToStudent(rs));
            }
        }
        return list;
    }
}