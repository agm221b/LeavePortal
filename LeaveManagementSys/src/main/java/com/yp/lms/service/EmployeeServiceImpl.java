package com.yp.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yp.lms.model.Employee;
import com.yp.lms.repository.EmployeeRepository;
import com.yp.lms.repository.LeaveRepository;

/**
 * 
 * @author Aditya Mishra
 *
 */
@Service
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

	@Override
	public Employee loginEmployee(String email, String password) {
		// TODO Auto-generated method stub
		Employee loginEmployee = employeeRepository.findEmployeeByEmailAndPassword(email, password);
		if(loginEmployee==null) {
			System.out.println("Incorrect email/password");
			return null;												//401 error
		}
		return loginEmployee;
	}


}
