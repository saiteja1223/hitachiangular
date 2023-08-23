import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServService {

  constructor(private http:HttpClient) { 


  }
  display(){
    return this.http.get('http://localhost:8090/api/v1/student')
  }
}
