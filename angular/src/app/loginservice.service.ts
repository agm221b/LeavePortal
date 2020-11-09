import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  private url='http://localhost:8022/FoodManagement/logincustomer';
  
  constructor(private http:HttpClient) { }
  checkCredantial(username:string,password:string){
    console.log(this.url);
    return this.http.get(this.url);
  }
  
}
