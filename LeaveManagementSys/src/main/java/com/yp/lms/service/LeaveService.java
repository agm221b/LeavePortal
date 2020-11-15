package com.yp.lms.service;

import java.util.ArrayList;

import com.yp.lms.model.Leave;

/**
 * 
 * @author Aditya Mishra
 *
 */
public interface LeaveService {
	Leave addLeave(Leave leave, int empId);
	Leave findLeave(Leave leave);
	int deleteLeave(Leave leave);
	ArrayList<Leave> findLeavesByEmployee(int empId);
	ArrayList<Leave> findLeavesForManager(int empId);
	
	Leave acceptLeave(Leave leave);
	Leave rejectLeave(Leave leave);

}
