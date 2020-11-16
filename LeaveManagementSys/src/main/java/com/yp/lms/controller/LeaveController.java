package com.yp.lms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yp.lms.model.Leave;
import com.yp.lms.service.LeaveService;
/**
 * 
 * @author Harish Maurya
 *
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/leave/")
public class LeaveController {

	@Autowired
	LeaveService service;

	public LeaveController(LeaveService service) {
		this.service = service;
	}
	
	@PostMapping("addLeaves")
	public ResponseEntity<Leave> createAddLeave(@RequestBody Leave leave,int empId){
		Leave leaves=service.addLeave(leave, empId);
		return ResponseEntity.ok(leaves);
	}
	
	@GetMapping("leavehistory")
	public ResponseEntity<Leave> createFindLeave(@RequestBody Leave leave){
		Leave leaves=service.findLeave(leave);
		return ResponseEntity.ok(leaves);
		
	}
	
	@DeleteMapping("deleteLeave")
	public ResponseEntity<Integer> createDeleteLeave(@RequestBody Leave leave){
		int leaves=service.deleteLeave(leave);
		return ResponseEntity.ok(leaves);
	}
	
	@GetMapping("leaveEmpid")
	public ResponseEntity<ArrayList<Leave>> createFindLeavesByEmployee(@RequestParam Integer empId){
		ArrayList<Leave> leaves=service.findLeavesByEmployee(empId);
		return ResponseEntity.ok(leaves);
	}
	
	@GetMapping("leaveManager")
	public ResponseEntity<ArrayList<Leave>> createFindLeavesForManager(@RequestParam Integer empId){
		ArrayList<Leave> leaves=service.findLeavesForManager(empId);
		return ResponseEntity.ok(leaves);
	}
	
	@PostMapping("acceptLeaves")
	public ResponseEntity<Leave> createAcceptLeave(@RequestBody Leave leave){
		Leave leaves=service.acceptLeave(leave);
		return ResponseEntity.ok(leaves);
	}
	
	@PostMapping("rejectLeaves")
	public ResponseEntity<Leave> createRejectLeave(@RequestBody Leave leave){
		Leave leaves=service.rejectLeave(leave);
		return ResponseEntity.ok(leaves);
	}
	
}
