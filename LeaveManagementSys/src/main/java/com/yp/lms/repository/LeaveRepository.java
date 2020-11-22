package com.yp.lms.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yp.lms.model.Employee;
import com.yp.lms.model.Leave;

/**
 * 
 * @author Aditya Mishra
 *
 */
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	Leave findLeaveByLeaveId(int leaveId);
	
	ArrayList<Leave> findLeaveByManagerId(int managerId);
	
	ArrayList<Leave> findLeaveByEmployee(Employee employee);

	
}
