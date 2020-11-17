package com.yp.lms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yp.lms.util.Status;

@Entity
@Table(name = "leaves")
public class Leave {
	@Id
	private int leaveId;
	@ManyToOne
	@JoinColumn(name="empId", nullable = false)
	private Employee employee;
	private int managerId;
	private String reason;
	private Date startDate;
	private Date endDate;
	private Status status;
	private int noOfDays;
	public Leave(int leaveId, Employee employee, int managerId, String reason, Date startDate, Date endDate,
			Status status, int noOfDays) {
		super();
		this.leaveId = leaveId;
		this.employee = employee;
		this.managerId = managerId;
		this.reason = reason;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.noOfDays = noOfDays;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	
	
}