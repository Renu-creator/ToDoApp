import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import { LoginFormComponent } from './login-form/login-form.component';
import {CommServiceService} from './comm-service.service';
import { HttpClientModule } from '@angular/common/http';

import { RouterModule,Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './employee/employee.component';
import { CreateTaskComponent } from './create-task/create-task.component';
import { RegisterTaskComponent } from './register-task/register-task.component';
import { DisplayTasksComponent } from './display-tasks/display-tasks.component';
import { ChkekboxdemoComponent } from './chkekboxdemo/chkekboxdemo.component';
import { Login2Component } from './login2/login2.component';
import { ChartDisplayComponent } from './chart-display/chart-display.component';
import { ChartsModule } from 'ng2-charts';
import { OTPandEmailComponent } from './otpand-email/otpand-email.component';
import { AuthGuard } from './auth.guard';


const appRoutes :Routes=[
  {path:'home',component:HomeComponent},
  {path:'emp',component:EmployeeComponent},
  {path:'login',canActivate:[AuthGuard],component:LoginFormComponent},
  {path:'admin',component:AdminComponent},
  {path:'signup',component:SignUpComponent},
  {path:'task',component:CreateTaskComponent},
  {path:'displaydetails',component:DisplayTasksComponent},
  {path:'chart',component:ChartDisplayComponent},
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'**',component:PageNotFoundComponent},
  
]

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginFormComponent,
    AdminComponent,
    PageNotFoundComponent,
    HomeComponent,
    EmployeeComponent,
    CreateTaskComponent,
    RegisterTaskComponent,
    DisplayTasksComponent,
    ChkekboxdemoComponent,
    Login2Component,
    ChartDisplayComponent,
    OTPandEmailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    ChartsModule,
    RouterModule.forRoot(appRoutes),
    
  ],
  providers: [CommServiceService,AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
