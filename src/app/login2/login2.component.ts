import { Component, OnInit } from '@angular/core';
import { CommServiceService } from '../comm-service.service';
import { LoginModel } from '../login-form/Login.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login2',
  templateUrl: './login2.component.html',
  styleUrls: ['./login2.component.css']
})
export class Login2Component implements OnInit {

  title="Welcome User";
  data:any;
  status:any;
  msg:any;
  LoginModel =new LoginModel();


  // loginfrm:FormGroup;
  // fname:String="";
  // pass:String="";

  // constructor(private rter:Router ) {
    
  //  }

  constructor(private loginapi:CommServiceService,private rter:Router,private taskrter:Router)
  { }

   onSignupButtonClick():void
   {
     this.rter.navigate(['/signup']);
   }

   onSubmit()
   {
    console.log(this.LoginModel);
     console.log("in submit-----");
    //this.loginapi.login(this.LoginModel).subscribe((resp:any)=>this.myfun(resp),error=>console.error(error()));   

    //this.loginapi.getEmplist().subscribe(data)
    
  }
 
  tp:any={};
  myfun(q)
  {
   this.tp=q;
   this.taskrter.navigate(['/task']);
  }   
   


 

  ngOnInit() 
  {
  }

}

    // {firstName: "ram", lastName: "patil", email: "ram@gmail.com", password: "ramram"}
    // login2.component.ts:32 

//     {emp: Array(5)}
// emp: Array(5)
// 0: {empid: 7, fname: "anay", lname: "patil", gen: "male", dobdate: "1996-05-05", …}
// 1: {empid: 8, fname: "vishal", lname: "patil", gen: "male", dobdate: "1996-06-07", …}
// 2: {empid: 9, fname: "kiti", lname: "patil", gen: "female", dobdate: "1993-03-07", …}
// 3: {empid: 10, fname: "kimaya", lname: "rao", gen: "female", dobdate: "2000-03-07", …}
// 4: {empid: 11, fname: "priya", lname: "singh", gen: "female", dobdate: "1999-02-02", …}
// length: 5




    // for(let i=0;i<this.model.length;i++)
    // {
  //   if(i==index)
  // {
  //     this.temp=this.data[i];
      // console.log(this.model[i]);
  // }
    //}
  
