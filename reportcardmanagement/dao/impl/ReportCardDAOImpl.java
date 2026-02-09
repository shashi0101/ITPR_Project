package com.project.reportcardmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.project.reportcardmanagement.dao.ReportCardDAO;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class ReportCardDAOImpl implements ReportCardDAO {

    // ================== STUDENT ==================
    @Override
    public Student getStudentById(String studentId) throws Exception {

        String sql = "SELECT * FROM student WHERE student_id = ?";
        Student student = null;

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setStudentId(rs.getString("student_id"));
                    student.setStudentName(rs.getString("student_name")); // correct setter
                    student.setClassName(rs.getString("class"));
                }
            }
        }

        return student;
    }

    // ================== MARKS ==================
    @Override
    public Map<String, Integer> getMarksByStudent(String studentId) throws Exception {

        Map<String, Integer> marksMap = new HashMap<>();
        String sql = "SELECT s.subject_name, m.marks " +
                     "FROM marks m " +
                     "JOIN subject s ON m.subject_code = s.subject_code " +
                     "WHERE m.student_id = ?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    marksMap.put(
                        rs.getString("subject_name"),
                        rs.getInt("marks")
                    );
                }
            }
        }

        return marksMap;
    }

    // ================== ATTENDANCE ==================
    @Override
    public int getTotalClasses(String studentId) throws Exception {

        int total = 0;
        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id = ?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getInt(1);
                }
            }
        }

        return total;
    }

    @Override
    public int getPresentCount(String studentId) throws Exception {

        int present = 0;
        String sql = "SELECT COUNT(*) FROM attendance " +
                     "WHERE student_id = ? AND status = 'P'";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    present = rs.getInt(1);
                }
            }
        }

        return present;
    }
}