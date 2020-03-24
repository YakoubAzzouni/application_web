import { Component, OnInit, Inject } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';
import { User } from 'src/app/models/user/user';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  login: User = new User();
  constructor(private loginService: LoginService, @Inject(SESSION_STORAGE) private storage: StorageService,
              private router: Router, private userService: UserService) { }

  ngOnInit() {

  }

  //**** methode ********
 Login(){
   let promise = new Promise((resolve, reject) => {
    this.loginService.Login(this.login)
    .subscribe((response: any) => {
    console.log(response);
    resolve(response);
    },
    err => {
      reject(err);
    }
    );
   });
   return promise;
 }

 getUser(){
   let promise = new Promise((resolve, reject) =>  {
    this.userService.getUser()
    .subscribe((response: any) => {
      resolve(response);
    },
    err => {
      reject(err);
    }
    );
   });
   return promise;
 }

 buttonLogin(){
   this.Login().then((response: any) => {
      if(response.status === "success"){
        this.getUser().then((response_user: any) =>{
          this.user.status = response_user.status;
          this.user.role = response_user.role;
          this.user.username = response_user.username;
          this.storage.set("session", this.user);
          if(this.user.role === "admin")
          {
             this.router.navigate(['/parkings']);
          }
          else
          {
            this.router.navigate(['/home']);
          }
        });
      }
   });
 }

}
