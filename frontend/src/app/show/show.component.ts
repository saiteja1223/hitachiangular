import { HttpClient } from '@angular/common/http';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { ServService } from '../serv.service';

export interface Data{
  id:any;
  name:String;
  addres:string;
}

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit ,OnChanges{

  item:any;
  values=1;
 
  constructor(private http:HttpClient,private router :Router,
    private serve:ServService){
  }
  ngOnChanges(changes:any): void {
    if(changes?.this.values!=0){
    this.serve.display().subscribe(data=>{
      this.item=data; this.values=this.item.length;
      console.log("hdsjkshi");
      
    })}
    
    
  }
  ngOnInit(): void {
    this.serve.display().subscribe(data=>{
      this.item=data;
      
      

    })
  }
  onProductCreate(products:(name:String,addres:String)=>{})
  {
    this.http.post('http://localhost:8090/api/v1/student',products)
    .subscribe((res)=>{
      console.log(res);
    }); 
    location.reload();

  }
  
  delete(id:any){
    const url=`http://localhost:8090/api/v1/student/${id}`;
    this.http.delete(url).subscribe();
    console.log(id);
    location.reload();

  }
  


}
