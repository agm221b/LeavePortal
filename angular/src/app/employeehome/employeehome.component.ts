import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employeehome',
  templateUrl: './employeehome.component.html',
  styleUrls: ['./employeehome.component.css']
})
export class EmployeehomeComponent implements OnInit {

  leaveslist: any;
  leave={
    "leaveId":"",
    "leaveDate":"",
    "leaveDays":"",
    "leaveReason":"",
    "leaveStatus":""
  }
  constructor(private router:Router) { }

  ngOnInit() {
    
    //let oberservableresult = this.dataservice.getleaveshistory();
    //oberservableresult.subscribe((result) => {
     // console.log(result); this.leave = result; 
    //})
  }



  
}
