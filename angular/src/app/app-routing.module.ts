import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { EmployeehomeComponent } from './employeehome/employeehome.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ProfileComponent } from './profile/profile.component';
import { EditprofileComponent } from './editprofile/editprofile.component';
import { LeaveComponent } from './leave/leave.component';
import { LeavehistoryComponent } from './leavehistory/leavehistory.component';


const routes: Routes = [
  { path : '', component : HomeComponent},
  { path : 'register', component : RegisterComponent},
  { path : 'employeehome', component : EmployeehomeComponent},
  { path : 'profile', component : ProfileComponent},
  { path : 'editprofile', component : EditprofileComponent},
  { path : 'leave', component : LeaveComponent},
  { path : 'leavehistory', component : LeavehistoryComponent},

  { path : '**', component : PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
