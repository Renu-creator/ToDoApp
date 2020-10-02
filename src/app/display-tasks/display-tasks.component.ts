import { Component, OnInit } from '@angular/core';
import { CommServiceService } from '../comm-service.service';
import { task } from '../Model/task.model';


@Component({
  selector: 'app-display-tasks',
  templateUrl: './display-tasks.component.html',
  styleUrls: ['./display-tasks.component.css'],
  providers:[CommServiceService]
})
export class DisplayTasksComponent implements OnInit {

 

  dataobj:any={};
  dataarr:any=[];
  
  task=new task();


  constructor(private displayserv:CommServiceService,private loginapi:CommServiceService) { }

  ngOnInit() {

    this.getTask();
  }

  ekey:any;

  getTask()
  {
    this.ekey=localStorage.getItem('key');
    console.log("in localstorage "+this.ekey);
    this.displayserv.getTasklist().subscribe(e=>{
      
      this.dataarr=e

       console.log(this.dataarr);

      
    });
  }
}
