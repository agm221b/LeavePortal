import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

empObj:any;

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

 //let observable = this.dataservice.getEmployee(empId);

  //observable.subscribe((result) => {
  //this.empObj=result;
  //  console.log(empObj);
  //});


}
get f() { return this.registerForm.controls; }
updateProfile() {

  this.submitted = true;

  if (this.registerForm.invalid) {
    return;
  }
  //let observable = this.dataservice.registerEmployee(this.registerForm.value);

  //observable.subscribe((result) => {
  //  alert(JSON.stringify(result));
  //});
  alert("Updated Details"+JSON.stringify(this.registerForm.value));
  this.router.navigate(['/profile']);
}

onReset() {
  this.submitted = false;
  this.registerForm.reset();
  this.router.navigate(['/editprofile']);
}

}
