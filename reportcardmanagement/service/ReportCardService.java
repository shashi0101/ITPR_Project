package com.project.reportcardmanagement.service;

import com.project.reportcardmanagement.model.ReportCard;

public interface ReportCardService {

    ReportCard generateReportCard(String studentId) throws Exception;
}