import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbaremployee',
  templateUrl: './navbaremployee.component.html',
  styleUrls: ['./navbaremployee.component.css']
})
export class NavbaremployeeComponent implements OnInit {

  employee:any;
  constructor(private router: Router) { }

  ngOnInit() {
    
  }



  isManager(){
   // if(employee.isManager==true){
   //   return true;
   // }
  }

  logout() {
    const res = confirm("Are you sure want to logout??");
    if (res == true) {
      //localStorage.removeItem('adminId');
      this.router.navigate(['/']);
    }
  }
}
