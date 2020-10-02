import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl,FormsModule,FormBuilder} from '@angular/forms';
import{task} from '../Model/task.model';

import { CommServiceService } from '../comm-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css'],
  providers:[CommServiceService]
})
export class CreateTaskComponent implements OnInit 
{

 task=new task();

 taskarray=[];
 num:number;
 title="Create Task";
 activeIndex=-1;
  // data: any;
  dataarr:any=[];

 // isActive=true;

 


  constructor(private httpvar:CommServiceService,private rter:Router) {
    
   } 

  //  key:any;
  k:any;
  
   ngOnInit() {

     this.k=localStorage.getItem('key');
    console.log("K is "+this.k);
      this.task.email=this.k;
     console.log("localstorage "+this.task);
     alert(JSON.stringify(this.task));
   this.gettaskdata();
   
  }

   gettaskdata()
    {
      this.httpvar.getTasklist().subscribe(e=>
       {
        this.dataarr=e;
       console.log(this.dataarr);
      }) 
    }
   onSubmit()
   {
     if(this.activeIndex==-1)
     {

    
      let k=localStorage.getItem('key');
      this.task.email=k;
     console.log("localstorage "+this.task);
      this.httpvar.addTask(this.task).subscribe(data=>{
        this.gettaskdata();
        alert("task created");
      })
    // this.taskarray.unshift(this.task);
    // this.task=new task();
     }
     else{

      alert("taskkkkk   "+this.task);
      this.httpvar.updateData(this.task).subscribe(data=>{
        this.gettaskdata();
      })
      //  this.taskarray.splice(this.activeIndex,1,this.task);
     }

     this.task=new task();
     this.title='Create Task';
     this.activeIndex=-1;
    // alert(JSON.stringify(this.taskarray));

   }

   obj:any={};

   deleteTask(i:number)
   {
    //  console.log(i);
    //  //this.num=i;

    // this.dataarr=data.Task
    //    console.log(this.dataar

      this.obj.taskid = this.dataarr[i].taskid;
   
    console.log(this.obj);

     this.httpvar.deleteData(this.obj).subscribe(data=>{
      this.gettaskdata();
    
    })


   // this.taskarray.splice(i);
   }
  
  editTask(obj,index)
  {
    console.log(obj);
    
    this.title='Update';
    //this.task.taskid=obj.
    this.task=obj;
    console.log(this.task);
   this.activeIndex=index;


  }

  selecteditems:any=[];
  obj2:any=[];
  obj3:any=[];
  json_arr = {};

  onCheckboxChange(e:any,taskid:any,status:any) 
  {
    console.log(e+"  "+taskid);
    this.obj2=taskid;
    this.json_arr=Object.assign({taskid});

     this.obj3 = JSON.stringify(this.json_arr);
      console.log("json string "+this.obj3);


    if(e.target.checked)
    {
      this.httpvar.updateTaskStatus(this.obj3).subscribe(data=>{
        this.gettaskdata();
        console.log(data);
      });

    }

  }


    logOut()
  {
    localStorage.removeItem(this.k);
    this.rter.navigate(['/login']);
    
  }

  }

















  



