import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  
  username :string = null;
  organization : string = null;
  empid : number = 0;
  mobileno : string = null;
  email : string = null;
  

  view:boolean = false;
  enable:boolean = false ;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.view = false;
  }


  register(): void {
    console.log(this.form.username);
    this.authService.register(this.form).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
        console.log(this.errorMessage);
      }
    );
  }

  preview() : void {
    console.log("In preview")
    if(this.form.dirty){
    this.view = true;
    this.enable = true;
    }
  }





}
