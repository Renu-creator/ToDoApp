import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,FormsModule,FormBuilder, Validators} from '@angular/forms';
import{Router} from '@angular/router';

import { CommServiceService } from '../comm-service.service';
import { OTPmodel } from './OTPModel.model';
import { PasswordValidator } from './password.validator';
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css'],
  providers: [DatePipe]
})
export class SignUpComponent implements OnInit {

  userObj: any = {};

  title='SignUp Form';


  fname:String="";
  lname:String="";
  gen:String="";
  dobdate:String="";
  pass:String="";
  cpass:String="";
  tdate:String="";
  email:String="";
  otp:String="";

  OTPmodel =new OTPmodel();

  

  constructor(public datepipe: DatePipe,public callApi:CommServiceService,private rte:Router,private forotp:CommServiceService,private fb:FormBuilder) 
  {}


    regfrm = this.fb.group({
      fname:['',[Validators.required,Validators.minLength(3)]],
      lname:['',[Validators.required,Validators.minLength(3)]],
       gen:['',[Validators.required]],
      dobdate:['',[Validators.required]],
      pass:[''],
      cpass:[''],
      tdate:['', [Validators.required]],
      email:['', [Validators.required]],
      otp:['',[Validators.required]],
    },{validator:PasswordValidator});


   date:any;
    datediff:number;
today_date:any;



   onSubmit(regfrm:any)
   {
     alert(this.regfrm.value.otp);
     alert("otp is "+JSON.stringify(this.obj));

    
     if(this.regfrm.value.otp==this.obj.status)
     {
      console.log(this.regfrm);
      this.callApi.addData(this.regfrm.value).subscribe((e:any)=>this.myfun(e),error=>console.error(error()));
     }
     else{
        alert("not added");
     }
    
   }

   tp:any={};
   myfun(q)
   {
    this.tp=q;
    alert("done....!!!");
    this.rte.navigate(['/login']);
   }   

   emailobje:any={};
   obj:any={};

   genOTP()
  {
    this.emailobje.email = this.regfrm.value.email;
    alert(JSON.stringify(this.emailobje));

    this.forotp.genOtp(this.emailobje).subscribe(data=>{

        console.log("from java otp is "+data);

        alert("from java otp is "+JSON.stringify(data));
  
        this.obj=data;

        alert("otp is "+JSON.stringify(this.obj));
  
      });
   
    
  }

  passwordcheck(control)
  {
    if(control.value!=null)
    {
      var conpass=control.value;
      var passw=control.root.get('pass');
      if(passw)
      {
        var pwd=passw.value;
        if(conpass!=="" &&  pwd!=="")
        {
          return{
            passwordValidity:true
          }
        }
        else
        {
          return null;
        
        }
      }
    }
  }

  ngOnInit() {
  }

}
