package com.yp.lms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.lms.model.Employee;
import com.yp.lms.model.Leave;
import com.yp.lms.repository.EmployeeRepository;
import com.yp.lms.repository.LeaveRepository;

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

}
