package com.yp.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
    BCryptPasswordEncoder encoder;

	
	
public EmployeeController(EmployeeService service, BCryptPasswordEncoder encoder) {
		super();
		this.service = service;
		this.encoder = encoder;
	}

@PostMapping("register")
public ResponseEntity<Employee> createaAddEmployee(@RequestBody Employee employee){
	employee.setPassword(encoder.encode(employee.getPassword()));
	Employee emp=service.addEmployee(employee);
	return ResponseEntity.ok(emp);
}

@GetMapping("profile")
public ResponseEntity<Employee> createFindEmployee(@RequestParam(value = "id") Integer empId){
	Employee emp=service.findEmployee(empId);
	return ResponseEntity.ok(emp);
}

@PostMapping("editProfile")
public ResponseEntity<Employee> createEditEmployeeDetails(@RequestBody Employee employee){
	employee.setPassword(encoder.encode(employee.getPassword()));
	Employee emp=service.editEmployeeDetails(employee);
	return ResponseEntity.ok(emp);
}

@PostMapping("login")
public ResponseEntity<Employee> createLoginEmployee(@RequestBody Employee employee ){
	Employee emp=service.loginEmployee(employee.getEmail(), employee.getPassword());
	return ResponseEntity.ok(emp);
}



	
	
	

}
