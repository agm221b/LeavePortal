package com.yp.lms.model;

/**
*
@author Pooja Tiwari and Nikita Padwal
*
*
**/
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String name;
	private String email;
	
	private String password;
	private String address;
	private int phoneNo;
	private int managerId;
	private int currentLeaves;
	private Blob image;
	private boolean isManager;
	@OneToMany(mappedBy = "employee")
	private List<Leave> leaveList = new ArrayList<Leave>();
	
	public Employee(int empId, String name, String email, String address, Blob image, int managerId, int currentLeaves,
			int phoneNo, boolean isManager, ArrayList<Leave> leaveList) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.managerId = managerId;
		this.currentLeaves = currentLeaves;
		this.image = image;
		this.isManager = isManager;
		this.leaveList = leaveList;
	}
 
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getCurrentLeaves() {
		return currentLeaves;
	}

	public void setCurrentLeaves(int currentLeaves) {
		this.currentLeaves = currentLeaves;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public boolean getIsManager() {
		return isManager;
	}

	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	public ArrayList<Leave> getLeaveList() {
		return (ArrayList<Leave>) leaveList;
	}

	public void setLeaveList(ArrayList<Leave> leaveList) {
		this.leaveList = leaveList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", phoneNo=" + phoneNo + ", managerId=" + managerId + ", currentLeaves=" + currentLeaves + ", image="
				+ image + ", isManager=" + isManager + ", leaveList=" + leaveList + "]";
	}


	
	
}
