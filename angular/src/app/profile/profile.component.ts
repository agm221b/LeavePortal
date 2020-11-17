import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

    //employee:any;
  employee =
    {
      "image": "",
      "name": "aditya",
      "email": "adi@gmail.com",
      "password":"aditya",
      "address": "pune",
      "phoneNo": "1212121212",
      "managerId": "123",
      "currentLeaves": "22",
      "leaveList":""
    }



  constructor(private service: DataService, private router: Router) { }

  ngOnInit() {
    //get object of employee
    //getEmployeee();
  }


  //  getEmployeee() {
  //  let observableResult = this.service.getEmployeeById();
  //  observableResult.subscribe((result) => {
  //    console.log(result);
  //  this.employee = result;
  //  });
  // }
}