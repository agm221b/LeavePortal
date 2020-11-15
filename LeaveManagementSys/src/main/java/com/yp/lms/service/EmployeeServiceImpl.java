package com.yp.lms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.lms.model.Employee;
import com.yp.lms.model.Leave;
import com.yp.lms.repository.EmployeeRepository;
import com.yp.lms.repository.LeaveRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	LeaveRepository leaveRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(findEmployee(employee.getEmpId())!=null){
			System.out.println("Employee already exists");
			return null;												//500 error
		}
		Employee saveEmployee = employeeRepository.save(employee);
		System.out.println("Employee added successfully");
		return saveEmployee;
	}

	@Override
	public Employee findEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeByEmpId(empId);
	}

	@Override
	public Employee editEmployeeDetails(Employee employee) {
		// TODO Auto-generated method stub
		if(findEmployee(employee.getEmpId())==null){
			System.out.println("Employee does not exist");
			return null;												//500 error
		}
		Employee saveEmployee = employeeRepository.save(employee);
		System.out.println("Employee updated successfully");
		return saveEmployee;
	}


}
