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

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
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
	
	@PostMapping("addleaves")
	public ResponseEntity<Leave> createAddLeave(@RequestBody Leave leave,@RequestParam int empId){
		Leave leaves=service.addLeave(leave, empId);
		return ResponseEntity.ok(leaves);
	}
	
	
	
	@DeleteMapping("deleteleave")
	public ResponseEntity<Integer> createDeleteLeave(@RequestParam Integer leaveId){
		int leaves=service.deleteLeave(leaveId);
		return ResponseEntity.ok(leaves);
	}
	
	@GetMapping("leaveempid")
	public ResponseEntity<ArrayList<Leave>> createFindLeavesByEmployee(@RequestParam Integer empId){
		System.out.println("values"+empId);
		System.out.println("list"+service.findLeavesByEmployee(empId));
		ArrayList<Leave> leaves=service.findLeavesByEmployee(empId);
		return ResponseEntity.ok(leaves);
	}
	
	@GetMapping("leavemanager")
	public ResponseEntity<ArrayList<Leave>> createFindLeavesForManager(@RequestParam Integer managerId){
		ArrayList<Leave> leaves=service.findLeavesForManager(managerId);
		return ResponseEntity.ok(leaves);
	}
	
	@PostMapping("acceptleaves")
	public ResponseEntity<Leave> createAcceptLeave(@RequestParam Integer leaveId){
		Leave leaves=service.acceptLeave(leaveId);
		return ResponseEntity.ok(leaves);
	}
	
	@PostMapping("rejectleaves")
	public ResponseEntity<Leave> createRejectLeave(@RequestParam Integer leaveid){
		Leave leaves=service.rejectLeave(leaveid);
		return ResponseEntity.ok(leaves);
	}
	
}
