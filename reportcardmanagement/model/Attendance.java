package com.project.reportcardmanagement.model;
import java.time.LocalDate;

public class Attendance {

    private String studentId;
    private LocalDate attendanceDate;
    private String status; // Present / Absent
    private String remarks;
    private int totalDays;
    private int presentDays;

   public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
		
	}
	
	 public int getPresentDays() {
			return presentDays;
		}

	public void setPresentDays(int presentDays) {
		this.presentDays = presentDays;
		
	}
}