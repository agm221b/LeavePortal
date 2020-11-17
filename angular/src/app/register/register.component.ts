import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

//id,name,email_id,address,phone number,image,manager_id,current leaves
  registerObj =
  {
    "profilePic":"",
    "firstName": "",
    "lastName": "",
    "custEmailId": "",
    "custAddress": "",
    "custmobileNumber": "",
    "customerPassword": "",
    "managerId":"",
    "currentLeaves" : ""
  }
registerForm: FormGroup;
submitted = false;
constructor(private formBuilder: FormBuilder,private route: ActivatedRoute,
  private router: Router,private dataservice:DataService) { }

ngOnInit() {
  this.registerForm = this.formBuilder.group({
    
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    address: ['', Validators.required],
    phoneNo: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10), 
                Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
    password: ['', [Validators.required, Validators.minLength(6)]],
    managerId: ['', Validators.required]
  })
}
get f() { return this.registerForm.controls; }
RegisterCustomer() {

  this.submitted = true;

  if (this.registerForm.invalid) {
    return;
  }
  //let observable = this.dataservice.registerEmployee(this.registerForm.value);

  //observable.subscribe((result) => {
  //  alert(JSON.stringify(result));
  //});
  alert(JSON.stringify(this.registerForm.value));
  this.router.navigate(['']);
}

onReset() {
  this.submitted = false;
  this.registerForm.reset();
  this.router.navigate(['/register']);
}

}
