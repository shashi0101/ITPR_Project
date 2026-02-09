package com.project.reportcardmanagement.dao.impl;

import com.project.reportcardmanagement.dao.MarksDAO;
import com.project.reportcardmanagement.model.Marks;
import com.project.reportcardmanagement.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAOImpl implements MarksDAO {

    private static final String TABLE = "marks";

    // ------------------ ADD MARKS ------------------
    @Override
    public boolean addMarks(Marks m) throws Exception {
        String sql = "INSERT INTO " + TABLE + " (student_id, subject_code, marks) VALUES (?,?,?)";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getStudentId());
            ps.setString(2, m.getSubjectCode());
            ps.setInt(3, m.getMarks());

            return ps.executeUpdate() > 0;
        }
    }

    // ------------------ UPDATE MARKS ------------------
    @Override
    public boolean updateMarks(Marks m) throws Exception {
        String sql = "UPDATE " + TABLE + " SET  marks=? WHERE student_id=? AND subject_code=?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

         
            ps.setInt(1, m.getMarks());
            ps.setString(2, m.getStudentId());
            ps.setString(3, m.getSubjectCode());

            return ps.executeUpdate() > 0;
        }
    }

    // ------------------ DELETE MARKS ------------------
    @Override
    public boolean deleteMarks(String studentId, String subjectCode) throws Exception {
        String sql = "DELETE FROM " + TABLE + " WHERE student_id=? AND subject_code=?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            ps.setString(2, subjectCode);

            return ps.executeUpdate() > 0;
        }
    }

    // ------------------ GET MARKS BY STUDENT ------------------
    @Override
    public List<Marks> getMarksByStudent(String studentId) throws Exception {
        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE + " WHERE student_id=?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToMarks(rs));
                }
            }
        }
        return list;
    }

    // ------------------ GET ALL MARKS ------------------
    @Override
    public List<Marks> getAllMarks() throws Exception {
        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE;

        try (Connection con = DataBaseUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToMarks(rs));
            }
        }
        return list;
    }

    // ------------------ UTILITY METHOD ------------------
    private Marks mapResultSetToMarks(ResultSet rs) throws SQLException {
        Marks m = new Marks();
        m.setStudentId(rs.getString("student_id"));
        m.setSubjectCode(rs.getString("subject_code"));
        m.setMarks(rs.getInt("marks"));
        return m;
    }
}