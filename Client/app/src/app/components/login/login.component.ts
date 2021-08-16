import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Constants} from "../../constants";
import { ModalDirective } from 'angular-bootstrap-md';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  @ViewChild('authenticationModal') authenticationModal: ModalDirective | any;

  //Setting up Interpolated variables
  username: string= '';
  password: string= '';
  errorMessage: string = '';


  constructor(private auth: AuthenticationService, private router: Router) { 
    console.log("Constructor for LoginComponent!!!");
  }

  ngAfterViewInIt(): void {
    this.authenticationModal.show();
  }

  ngOnInit(): void {
    if(localStorage.getItem('user')){
      this.router.navigate(['/users']);
    }
  }

  showModal(): void {
    if(!localStorage.getItem('user')){
      this.authenticationModal.show();
    }
  }

  login(): void {
    this.auth.authenticate(this.username, this.password).subscribe(data =>{
      if(!localStorage.getItem("user")){
        this.errorMessage = "Username / Password are incorrect"
      } else {
        this.router.navigate(['/users']);
      }
    },
    error => {
      this.errorMessage = Constants.INTERNAL_SERVER_ERROR;
    }
    )
  }

  clearFormData(): void {
    this.errorMessage="";
    this.password="";
  }

}
