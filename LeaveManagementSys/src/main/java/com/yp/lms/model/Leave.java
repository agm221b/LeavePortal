package com.yp.lms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Leave")
public class Leave {
	private int leaveId;
	private int empId;
	private int managerId;
	private String reason;
	private Date startDate;
	private Date endDate;
	private String Status;
	private int noOfDays;
	
	public Leave(int leaveId, int empId, int managerId, String reason, Date startDate, Date endDate, String status,
			int noOfDays) {
		super();
		this.leaveId = leaveId;
		empId = empId;
		this.managerId = managerId;
		this.reason = reason;
		this.startDate = startDate;
		this.endDate = endDate;
		Status = status;
		this.noOfDays = noOfDays;
	}

	@ManyToOne
	@Id
	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	@JoinColumn(name="empId")
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		empId = empId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", EmpId=" + empId + ", managerId=" + managerId + ", reason=" + reason
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", Status=" + Status + ", noOfDays=" + noOfDays
				+ "]";
	}
	

}
