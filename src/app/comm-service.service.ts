import { Injectable } from '@angular/core';
import {HttpClient,HttpParams} from '@angular/common/http';
// import {Http} from '@angular/http';
// import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class CommServiceService {

  constructor(public httpvar: HttpClient) {
    //return this.httpvar
   }

   
   addData(data)
   {
     //console.log("data is = "+typeof(data));
     return this.httpvar.post("http://localhost:8080/ToDoApp/AddEmp",data);
   }

   login(data)
   {
    return this.httpvar.post("http://localhost:8080/ToDoApp/LoginServlet",data);
   }

  //  adminlogin(data)
  //  {
  //   return this.httpvar.post("http://localhost:8080/ToDoApp/AdminLoginServlet",data);
  //  }

   updateData(data)
  {
    //console.log("data is = "+typeof());
    return this.httpvar.post("http://localhost:8080/ToDoApp/UpdateTask",data);
  }

  deleteData(i) 
  {
    //throw new Error("Method not implemented.");
    // console.log("data is = "+typeof(i));
    return this.httpvar.post("http://localhost:8080/ToDoApp/DeleteTask",i);
  }

  ekey:any;
  getTasklist()
  {
    this.ekey=localStorage.getItem('key');
    let params1=new HttpParams().set('email','ekey');
    return this.httpvar.get("http://localhost:8080/ToDoApp/DisplayTaskList",{params:params1});
  }

  getEmplist()
  {
    //console.log("data is = "+typeof());
    return this.httpvar.get("http://localhost:8080/ToDoApp/DisplayEmp");
  }

  getEmpCount()
  {
    //console.log("data is = "+typeof());
    return this.httpvar.get("http://localhost:8080/ToDoApp/CountEmp");
  }

  addTask(info)
  {
    return this.httpvar.post("http://localhost:8080/ToDoApp/TaskServlet",info);

  }

  updateTaskStatus(data)
  {
    //console.log("data is = "+typeof());
    return this.httpvar.post("http://localhost:8080/ToDoApp/UpdateTaskStatus",data);
  }

  updateEmpStatus(data)
  {
    //console.log("data is = "+typeof());
    return this.httpvar.post("http://localhost:8080/ToDoApp/UpdateEmpStatus",data);
  }


  genOtp(data)
  {
    return this.httpvar.post("http://localhost:8080/ToDoApp/GenerateOtp",data);
  }


}
