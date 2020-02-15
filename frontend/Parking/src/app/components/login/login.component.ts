import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  users: Array<any> = new Array();
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  //**** methode ********
  getAllUsers(){

    let promise = new Promise((resolve, reject) => {
      this.loginService.getAllUsers()
     .subscribe((response: any) => {
       console.log(response);
       this.users = response; // response fih jason t9ochi
       resolve(response);
       },
     err => {
       console.log(  err.status );
       reject(err);
      });
    });
    return promise;
  }
}
