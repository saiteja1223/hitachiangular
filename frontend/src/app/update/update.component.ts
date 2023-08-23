import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  id:any;
  constructor(private route:ActivatedRoute,
    private http:HttpClient,private location:Location){}
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
      console.log(this.id);
  }
onProductCreate(products:(name:String,addres:String)=>{}){
  this.http.put(`http://localhost:8090/api/v1/student/${this.id}`,products)
    .subscribe((res)=>{
      console.log(res)});
      location.reload();
      this.location.back();

}
}
