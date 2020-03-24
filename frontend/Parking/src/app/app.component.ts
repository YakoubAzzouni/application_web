import { Component, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import { User } from './models/user/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'parking';

  user: User = new User();

  constructor (router: Router, @Inject(SESSION_STORAGE) private storage: StorageService){}

  ngOnInit() {
    if(!(this.storage.get("session")))
    {

      this.user.status = "Not Logged";
      this.user.role = null;
      this.user.username = null;
      this.storage.set("session",this.user);
    }
  }
}
