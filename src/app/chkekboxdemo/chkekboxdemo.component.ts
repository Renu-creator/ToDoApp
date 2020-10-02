import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import{Router} from '@angular/router';
import { CommServiceService } from '../comm-service.service';

@Component({
  selector: 'app-chkekboxdemo',
  templateUrl: './chkekboxdemo.component.html',
  styleUrls: ['./chkekboxdemo.component.css']
})
export class ChkekboxdemoComponent implements OnInit {
  
  taskid:any="";
  taskname:String="";
  desc:String="";
  taskstatus:String="";

  activeIndex=-1;
  title="Create Task";

  data:any=[];

  taskform: FormGroup;
  
  

  constructor(private fb: FormBuilder,public httpvar:CommServiceService,private rte:Router) { 
    this.taskform = this.fb.group({
      taskid:new FormControl(),
      taskname:new FormControl(),
      desc:new FormControl(),
      taskstatus:new FormControl(),
      // checkArray: this.fb.array([], [Validators.required])
    });
  }


  gettaskdata()
  {
    this.httpvar.getTasklist().subscribe(e=>
     {
      this.data=e;
     console.log(e);
    }) 
  }


onSubmit()
 {
   if(this.activeIndex==-1)
   {

    this.httpvar.addTask(this.taskform.value).subscribe(data=>{
      this.gettaskdata();
      // alert("task created");
    })
  
   }
   else{

    this.httpvar.updateData(this.temp).subscribe(data=>{
      this.gettaskdata();
    })
   
   }
    this.title='Create Task';
   this.activeIndex=-1;
  

 }

  onCheckboxChange(e) 
  {
    
    const checkArray: FormArray = this.taskform.get('checkArray') as FormArray;
    if (e.target.checked)
     {
      checkArray.push(new FormControl(e.target.value));
    } 
    else 
    {
      let i: number = 0;
      checkArray.controls.forEach((item: FormControl) => 
      {
        if (item.value == e.target.value)
         {
          checkArray.removeAt(i);
          return;
        }
        i++;
      });
    }

      this.httpvar.updateTaskStatus(checkArray.value).subscribe(info=>
        {
        console.log(checkArray.value);
        this.gettaskdata();
      });
    
  }

  changedStatus()
  {}
  
  
  ngOnInit() {

    this.gettaskdata();
  }



temp:any={};

  editTask(index)
  {
    alert("ok");
   // console.log(obj);
    for(let i=0;i<this.data.length;i++)
    {
if(i==index)
{
this.temp=this.data[i];
console.log(this.data[i]);
}
    }
    //this.title='Update';
    //this.task.taskid=obj.
   // this.taskform=this.temp;
  //   console.log(this.taskform);
  // this.activeIndex=index;


  }


  obj:any={};


  deleteTask(i:number)
  {
     this.obj.taskid = this.data[i].taskid;
  
   console.log(this.obj);

    this.httpvar.deleteData(this.obj).subscribe(data=>
      {
     this.gettaskdata();
   
   })

  }
}