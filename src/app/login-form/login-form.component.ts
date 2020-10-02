import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,FormsModule,FormBuilder} from '@angular/forms';
import{Router} from '@angular/router';
import { LoginModel } from './Login.model';
import { CommServiceService } from '../comm-service.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  title="Welcome User";
  data:any;
  data1:any;
  status:any;
  msg:any;
  LoginModel =new LoginModel();
  ekey:any;

  constructor(private loginapi:CommServiceService,private rter:Router,private adminrter:Router,private taskrter:Router,private forotp:CommServiceService)
  { }

   onSignupButtonClick():void
   {
     this.rter.navigate(['/signup']);
   }

   tp:any={};
   //arr1:any=[];
   st:any;

   onSubmit()
   {
    console.log(this.LoginModel);
     console.log("in submit-----");

     localStorage.setItem('key',this.LoginModel.email);

            this.loginapi.login(this.LoginModel).subscribe(data=>{
              this.tp=data;
            
              console.log(this.tp.status);

              

              this.st=this.tp.status;
      
                  if(this.st==1)
              {
                this.ekey=localStorage.getItem('key');
                  this.taskrter.navigate(['/task']);
                 
              }
                else if(this.st==2)
              {
                  this.adminrter.navigate(['/emp']);
               }
               else
               {
                 alert("Please Enter Valid credentials....");
               }
            
        });
  }


  
ngOnInit() 
  {
    
    
  }

}







