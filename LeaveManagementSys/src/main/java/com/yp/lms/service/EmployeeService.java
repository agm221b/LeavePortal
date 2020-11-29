package com.yp.lms.service;

import java.util.ArrayList;

import com.yp.lms.model.Employee;

/**
 * 
 * @author Aditya Mishra
 *
 */
public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	Employee findEmployee(int empId);
	Employee editEmployeeDetails(Employee employee,Integer empId);
	
	Employee loginEmployee(String email, String password);
	
	ArrayList<Employee> isManager();
	
	
	
	
	

}
