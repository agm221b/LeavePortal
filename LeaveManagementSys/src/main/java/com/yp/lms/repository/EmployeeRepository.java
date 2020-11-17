package com.yp.lms.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yp.lms.model.Employee;

/**
 * 
 * @author Aditya Mishra
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findEmployeeByEmpId(int empId);
	Employee findEmployeeByEmailAndPassword(String email, String password);
	ArrayList<Employee> findEmployeesByIsManager(boolean isManager);
	Employee findEmployeeByEmail(String email);

}
