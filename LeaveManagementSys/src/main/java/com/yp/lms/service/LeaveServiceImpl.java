package com.yp.lms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yp.lms.model.Employee;
import com.yp.lms.model.Leave;
import com.yp.lms.repository.EmployeeRepository;
import com.yp.lms.repository.LeaveRepository;
import com.yp.lms.util.Status;

/**
 * 
 * @author Aditya Mishra
 *
 */
@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	LeaveRepository leaveRepository;

	@Override
	public Leave addLeave(Leave leave, int empId) {
		// TODO Auto-generated method stub
		if(findLeave(leave)!= null) {
			System.out.println("Leave exists");
		}
		Employee saveEmployee = employeeRepository.findEmployeeByEmpId(empId);
		leave.setManagerId(saveEmployee.getManagerId());
		saveEmployee.getLeaveList().add(leave);
		int currentLeaves = saveEmployee.getCurrentLeaves();
		currentLeaves = currentLeaves - leave.getNoOfDays();
		if(currentLeaves < 0) {
			System.out.println("Exceeded Leave limit");
			return null;														//500 error
		}
		saveEmployee.setCurrentLeaves(currentLeaves);
		Leave saveLeave = leaveRepository.save(leave);
		employeeRepository.save(saveEmployee);
		return saveLeave;
	}

	@Override
	public Leave findLeave(Leave leave) {
		// TODO Auto-generated method stub
		return leaveRepository.findLeaveByLeaveId(leave.getLeaveId());
	}

	@Override
	public int deleteLeave(Leave leave) {
		// TODO Auto-generated method stub
		if(findLeave(leave)==null) {
			System.out.println("Leave does not exist");
			return 0;														//500 error
		}
		Employee deleteEmployee = employeeRepository.findEmployeeByEmpId(leave.getEmpId());
		ArrayList<Leave> leaveList = deleteEmployee.getLeaveList();
		if(leaveList.remove(leave)) {
			System.out.println("Leave removed from employee's list");
		}
		deleteEmployee.setLeaveList(leaveList);
		leaveRepository.delete(leave);
		System.out.println("Leave deleted from leaves database");
		return 1;
	}

	@Override
	public ArrayList<Leave> findLeavesByEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeByEmpId(empId).getLeaveList();
	}

	@Override
	public ArrayList<Leave> findLeavesForManager(int empId) {
		// TODO Auto-generated method stub
		return leaveRepository.findLeaveByManagerId(empId);
	}

	@Override
	public Leave acceptLeave(Leave leave) {
		// TODO Auto-generated method stub
		Employee saveEmployee = employeeRepository.findEmployeeByEmpId(leave.getEmpId());
		ArrayList<Leave> saveLeaveList = saveEmployee.getLeaveList();
		Leave saveLeave = null;
		int index=-1;
		int count=0;
		for (Leave leave2 : saveLeaveList) {
			if(leave2.getLeaveId() == leave.getLeaveId()) {
				saveLeave = leave2;
				index= saveLeaveList.indexOf(leave2);
				count++;
			}
		}
		if(count>1) {
			System.out.println("Error, multiple leaves of same leaveId in Emps");
			return null;															//500 error
		}
		saveLeave.setStatus(Status.ACCEPTED);
		
		saveLeaveList.set(index, saveLeave);
		saveEmployee.setLeaveList(saveLeaveList);
		
		employeeRepository.save(saveEmployee);
		leaveRepository.save(saveLeave);
		return saveLeave;
	}

	@Override
	public Leave rejectLeave(Leave leave) {
		// TODO Auto-generated method stub
		Employee saveEmployee = employeeRepository.findEmployeeByEmpId(leave.getEmpId());
		ArrayList<Leave> saveLeaveList = saveEmployee.getLeaveList();
		Leave saveLeave = null;
		int index=-1;
		int count=0;
		for (Leave leave2 : saveLeaveList) {
			if(leave2.getLeaveId() == leave.getLeaveId()) {
				saveLeave = leave2;
				index= saveLeaveList.indexOf(leave2);
				count++;
			}
		}
		if(count>1) {
			System.out.println("Error, multiple leaves of same leaveId in Emps");
			return null;															//500 error
		}
		saveLeave.setStatus(Status.REJECTED);
		
		int currentLeaves = saveEmployee.getCurrentLeaves();
		currentLeaves = currentLeaves + saveLeave.getNoOfDays();
		saveEmployee.setCurrentLeaves(currentLeaves);
		
		saveLeaveList.set(index, saveLeave);
		saveEmployee.setLeaveList(saveLeaveList);
		
		employeeRepository.save(saveEmployee);
		leaveRepository.save(saveLeave);
		return saveLeave;
	}
	
	

	
	
}
