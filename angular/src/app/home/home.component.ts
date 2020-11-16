import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }
  credantial = { "username": "", "password": "" };
  errorMessage = "";
  ngOnInit() {
  }

  // myFunction() {
  //   document.getElementById("myDropdown").classList.toggle("show");
  // }


  login() {
    console.log(this.credantial);
    if (this.credantial.username == "admin@gmail.com" && this.credantial.password == "admin") {

      this.router.navigate(['/employeehome']);
    }
    else {
      this.errorMessage = "username/password is wrong";
    }
  }
}
