import { Component, OnInit, Inject } from '@angular/core';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import { User } from 'src/app/models/user/user';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: User = new User();

  constructor(@Inject(SESSION_STORAGE) private storage: StorageService) { }

  get sessionInfo(){
    return this.storage.get("session");
  }

  ngOnInit(): void {
  }
}
