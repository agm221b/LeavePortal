package com.yp.lms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	

    @Autowired
    BCryptPasswordEncoder encoder;


	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(findEmployee(employee.getEmpId())!=null || employeeRepository.findEmployeeByEmail(employee.getEmail())!=null){
			System.out.println("Employee already exists");
			return null;												//500 error
		}
		//employee.setLeaveList(null);
		employee.setCurrentLeaves(10);
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
		
		Employee saveEmployee = employeeRepository.findEmployeeByEmpId(employee.getEmpId());
		if(saveEmployee==null) {
			System.out.println("Employee does not exist");
			return null;												
		}
		saveEmployee.setAddress(employee.getAddress());
		saveEmployee.setCurrentLeaves(employee.getCurrentLeaves());
		saveEmployee.setEmail(employee.getEmail());
		saveEmployee.setImage(employee.getImage());
		//saveEmployee.setLeaveList(employee.getLeaveList());
		saveEmployee.setIsManager(employee.getIsManager());
		saveEmployee.setManagerId(employee.getManagerId());
		saveEmployee.setName(employee.getName());
		saveEmployee.setPassword(employee.getPassword());
		saveEmployee.setPhoneNo(employee.getPhoneNo());
		
		employeeRepository.save(saveEmployee);
		System.out.println("Employee updated successfully");
		return saveEmployee;
	}

	@Override
	public Employee loginEmployee(String email, String password) {
		// TODO Auto-generated method stub
		String verifyPassword = employeeRepository.findEmployeeByEmail(email).getPassword();
		System.out.println("verifyPassword is "+verifyPassword);
		System.out.println("password is "+password);
		if (encoder.matches(password, verifyPassword))
		{
			Employee loginEmployee = employeeRepository.findEmployeeByEmailAndPassword(email,verifyPassword );
			if(loginEmployee==null) {
				System.out.println("Incorrect email/password 1");
				return null;												//401 error
			}
			return loginEmployee;
		}
		else
		{   System.out.println("Incorrect email/password 2");
			return null;
		}
		
		
	}

	@Override
	public ArrayList<Employee> isManager() {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeesByIsManager(false);
		
	}


}
