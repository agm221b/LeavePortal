package com.yp.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yp.lms.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findEmployeeByEmpId(int empId);

}
