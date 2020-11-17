import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class DataService {

private empUrl    = "http://localhost:8022/LeaveManagement/api/v1/emp/";
private leaveUrl  = "http://localhost:8022/LeaveManagement/api/v1/leave/";

  constructor(private http: HttpClient, private router: Router) { }





  registerEmployee(employeeObj){
    return this.http.post(this.empUrl + "register",employeeObj);
  }

  getEmployee(empId){
    return this.http.get(this.empUrl + "profile?empId=" + empId );
  }

  editProfile(employeeObj){
    return this.http.post(this.empUrl + "register",employeeObj);
  }

  checkLogin(loginObj){
    return this.http.post(this.empUrl + "login",loginObj);

  }

  ApplyLeaves(leaveObj,empId){
    return this.http.post(this.leaveUrl + "addleaves",leaveObj,empId);
  }
  
  getLeavesHistory(leaveObj){
    return this.http.get(this.empUrl + "leavehistory",leaveObj);
  }

  deleteLeaves(leaveObj){
    return this.http.delete(this.leaveUrl + "deleteLeave");
  }



  getLeavesByEmpId(empId){
    return this.http.get(this.leaveUrl + "leaveEmpid",empId);
  }

  getLeaveByForManger(empId){
    return this.http.get(this.leaveUrl + "leaveManger?empId=",empId)
  }

  acceptLeave(leaveObj){
    return this.http.post(this.leaveUrl + "acceptLeaves",leaveObj)
  }

  rejectLeave(leaveObj){
    return this.http.post(this.leaveUrl + "rejectLeaves",leaveObj)
  }









}
