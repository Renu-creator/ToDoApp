import { Component, OnInit } from '@angular/core';
import { ChartofempService } from '../chartofemp.service';
import {Chart} from 'chart.js';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chart-display',
  templateUrl: './chart-display.component.html',
  styleUrls: ['./chart-display.component.css']
})
export class ChartDisplayComponent  implements OnInit
{

  chart:any=[];


    constructor(private chartservicevar:ChartofempService,private rter:Router,private backrter:Router)
     {      }

     count:any=[];
     act:number;
     dact:any;
     totaltask:any;

    ngOnInit()
    {
      this.chartservicevar.getEmpCount().subscribe(data=>{
        this.count=data;
        console.log(this.count);

        for(let i=0;i<this.count.length;i++)
        {
          if(i==0)
          {
            this.act=this.count[i];
            console.log(this.act);
          }
          else if(i==1)
          {
            this.dact=this.count[i];
            console.log(this.dact);
          }
          else if(i==2)
          {
            this.totaltask=this.count[i];
            console.log(this.totaltask);
          }
            

        }

      this.chart=new Chart('canvas',
      {
        type:'bar',
        data:{
          labels:["ActiveUsers","DeactiveUsers","Total Tasks"],
          datasets:[
            {
              label:'Active Users in last 7 days',
              data:[this.act,this.dact,this.totaltask],
              
              backgroundColor:['blue','red','green'],
              borderColor:'red',
              fill:false,

            },
            
          ]
        },
        options:
        {
          title:{
            text:"Graphical Representation of ToDoApplication",
            display:true
          },
          scales:{
            yAxes:[{
              ticks:{
                beginAtZero:true

            }
          }]
          }
        }
      });
    });


    }





    logOut()
  {
    // localStorage.removeItem(this.k);
    this.rter.navigate(['/login']);
    
  }

  Back()
  {
    // localStorage.removeItem(this.k);
    this.rter.navigate(['/emp']);
    
  }


}
