import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ChartofempService {

  constructor(private httpc:HttpClient) { }

  getEmpCount()
  {
    
    return this.httpc.get("http://localhost:8080/ToDoApp/CountEmp");
  }
  
  
  
  
  
  
}




// :Observable<>
//   {
//   return this.httpc.get("http://localhost:8080/ToDoApp/CountEmp").map(result=>result);
// }
