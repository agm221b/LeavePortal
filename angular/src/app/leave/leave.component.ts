import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {

  leave = { "leaveDate": "", "leaveDays": "", "leaveReason": "" }

  registerForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,
    private dataservice: DataService, private router: Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      leaveDays: ['', Validators.required],
      leaveReason: ['', Validators.maxLength(150)]
    })
  }

  get f() { return this.registerForm.controls; }

  ApplyLeave() {

    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;
    }

    // let observable = this.dataservice.addAdmin(this.registerForm.value);
    // observable.subscribe((result) => {
    //  alert(JSON.stringify(result));
    // this.router.navigate(['/adminlogin']);
    // })

  }

  onReset() {
    this.submitted = false;
    this.registerForm.reset();
    this.router.navigate(['/leave']);

  }

}
