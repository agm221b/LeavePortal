package com.yp.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yp.lms.model.Employee;
import com.yp.lms.service.EmployeeService;
/**
 * 
 * @author Harish Maurya
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/emp/")
public class EmployeeController {
	
	@Autowired
	 EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
@PostMapping("register")
public ResponseEntity<Employee> createaddEmployee(@RequestBody Employee employee){
	Employee emp=service.addEmployee(employee);
	return ResponseEntity.ok(emp);
}

@GetMapping("profile")
public ResponseEntity<Employee> createfindEmployee(@RequestParam(value = "id") Integer empId){
	Employee emp=service.findEmployee(empId);
	return ResponseEntity.ok(emp);
}

@PostMapping("editProfile")
public ResponseEntity<Employee> createeditEmployeeDetails(@RequestBody Employee employee){
	Employee emp=service.addEmployee(employee);
	return ResponseEntity.ok(emp);
}

@PostMapping("login")
public ResponseEntity<Employee> createloginEmployee(@RequestBody Employee employee ){
	Employee emp=service.loginEmployee(employee.getEmail(), employee.getPassword());
	return ResponseEntity.ok(emp);
}



	
	
	

}
