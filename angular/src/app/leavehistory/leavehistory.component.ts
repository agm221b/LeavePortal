import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leavehistory',
  templateUrl: './leavehistory.component.html',
  styleUrls: ['./leavehistory.component.css']
})
export class LeavehistoryComponent implements OnInit {

  leaveslist: any;

  constructor(private service: DataService,private router: Router) { }

  ngOnInit() {

    //this.getData()
  }
 // getData() {
 //   let observableResult = this.service.ListLeaves();
 //   observableResult.subscribe((result) => {
 //     console.log(result);
 //   this.leaveslist = result;
 //   });
 // }

}
