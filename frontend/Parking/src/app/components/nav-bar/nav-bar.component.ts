import { Component, OnInit, Inject } from '@angular/core';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { StorageService, SESSION_STORAGE } from 'angular-webstorage-service';
import { LoginService } from 'src/app/services/login/login.service';
import { User } from 'src/app/models/user/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  user: User = new User();
  constructor( @Inject(SESSION_STORAGE) private storage: StorageService, private  loginservice: LoginService,  private router: Router) {}


  ngOnInit() {
  }

  get sessionInfo(){
    return this.storage.get("session");
  }

  leave(){
    this.logout().catch((err: any) => {
      this.user.role = null;
      this.user.username = null;
      this.user.status = "Not Logged";
      this.storage.set("session", this.user);
      this.router.navigate(['/home']);
    });
  }

  logout(){
    let promise = new Promise((resolve, reject) =>{
      this.loginservice.logout()
      .subscribe((response: any) =>{
        resolve(response);
      },
      err => {
        reject(err);
      }
      );
    });
    return promise;
  }
}
