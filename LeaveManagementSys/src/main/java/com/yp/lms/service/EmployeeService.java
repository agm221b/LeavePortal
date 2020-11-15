package com.yp.lms.service;

import java.util.ArrayList;

import com.yp.lms.model.Employee;
import com.yp.lms.model.Leave;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	Employee findEmployee(int empId);
	Employee editEmployeeDetails(Employee employee);
	
	
	
	
	

}
