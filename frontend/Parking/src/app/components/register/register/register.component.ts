import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user/user';
import { UserService } from 'src/app/services/user/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  constructor(private userService: UserService,  private router: Router) { }

  ngOnInit() {
    this.user.role = "user";
  }

  register(){
    this.creatUser().then((respnse: any) =>{
      this.router.navigate(['/home']);
    });
  }

  creatUser(){
    let promise = new Promise((resolve, reject) =>{
      this.userService.creatUser(this.user)
      .subscribe((response: any) =>{
        console.log(response);
       resolve(response);
      },
      err => {
        reject(err);
      });
    });
    return promise;
  }

}
