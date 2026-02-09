package com.project.reportcardmanagement.dao.impl;

import java.sql.*;

import com.project.reportcardmanagement.dao.ExamDAO;
import com.project.reportcardmanagement.model.Exam;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class ExamDAOImpl implements ExamDAO {

    @Override
    public boolean addExam(Exam exam) throws Exception {

    	String sql = "INSERT INTO exam (student_id, exam_type, is_eligible, exam_date) VALUES (?, ?, ?, ?)";
        Connection con = DataBaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, exam.getStudentId());
        ps.setString(2, exam.getExamType());
        ps.setString(3, exam.getIsEligible());
        ps.setString(4, exam.getExamDate());

        return ps.executeUpdate() > 0;
    }

    @Override
    public Exam getExamByStudentId(String studentId) throws Exception {

        String sql = "SELECT * FROM exam WHERE student_id = ?";
        Connection con = DataBaseUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, studentId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Exam exam = new Exam();
            exam.setStudentId(rs.getString("student_id"));
            exam.setExamType(rs.getString("exam_type"));
            exam.setExamDate(rs.getString("exam_date"));
            exam.setIsEligible(rs.getString("is_eligible"));
            return exam;
        }
        return null;
    }
}