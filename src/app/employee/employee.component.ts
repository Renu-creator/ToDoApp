import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommServiceService } from '../comm-service.service';


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  dataobj:any={};
  dataarr:any=[];

  constructor(private displayempserv:CommServiceService,private rter:Router) { }

  ngOnInit() {
    this.getEmp();
  }

  getEmp()
  {
    this.displayempserv.getEmplist().subscribe(e=>{
      
      this.dataarr=e;
       console.log(this.dataarr)
    });
  }

  obj2:any=[];
  obj3:any=[];
  json_arr = {};


  activateEmp(e:any,empid:any)
  {
    console.log(e+"  "+empid);
    this.obj2=empid;
    this.json_arr=Object.assign({empid});

     this.obj3 = JSON.stringify(this.json_arr);
      console.log("json string "+this.obj3);
      
      this.displayempserv.updateEmpStatus(this.obj3).subscribe(data=>{
        this.getEmp();
        console.log(data);
       });

      //}
  }

  deactivateemp(e:any,empid:any)
  {
      console.log(e+"  "+empid);
      this.obj2=empid;
      this.json_arr=Object.assign({empid});
  
       this.obj3 = JSON.stringify(this.json_arr);
        console.log("json string "+this.obj3);

        this.displayempserv.updateEmpStatus(this.obj3).subscribe(data=>{
          this.getEmp();
          console.log(data);
        });
      }
    // }


    genReport()
    {
      this.rter.navigate(['/chart']);

    }



    logOut()
  {
   
    this.rter.navigate(['/login']);
    
  }
  
}
