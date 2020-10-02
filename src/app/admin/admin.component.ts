import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,FormsModule,FormBuilder} from '@angular/forms';
import{Router} from '@angular/router';

import { CommServiceService } from '../comm-service.service';
import {adminloginmodel} from './adminmodel.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  title="Welcome User";
  data:any;
  status:any;
  msg:any;
  //adminloginmodel=new 
  adminloginmodel=new adminloginmodel();


  constructor(private loginapi:CommServiceService,private rter:Router)
  { }

  // private disprter:Router

  //  onSignupButtonClick():void
  //  {
  //    this.rter.navigate(['/signup']);
  //  }

   onSubmit()
   {
    console.log(this.adminloginmodel);
     console.log("in submit-----");
    this.loginapi.login(this.adminloginmodel).subscribe((resp:any)=>this.myfun(resp),error=>console.error(error()));   
    // this.rter.navigate(['/displaydetails']);
  }
 
  tp:any={};

  myfun(q)
  {
   this.tp=q;
   this.rter.navigate(['/displaydetails']);
  // this.disprter.navigate(['/displaydetails']);
  }   
   

  

  ngOnInit() {
  }

}
