import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient , HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
   /*   ******************** */
   private API_URL = environment.API_URL + "/";

   /*   ******************** */
   constructor(private httpClient: HttpClient) { }

   /********* methodes  **********/
   Login (user) {
    const body = new HttpParams()
      .set('username', user.username)
      .set('password', user.password);

    return this.httpClient.post(this.API_URL + 'login',
      body.toString(),
      {
        headers: new HttpHeaders()
       .set('Content-Type', 'application/x-www-form-urlencoded'),
        withCredentials: true
      }
    );
  }


  logout() {
    return this.httpClient.get(this.API_URL + "logout",
      {
        headers:  new HttpHeaders()
          .set('Content-Type', 'application/json')
          .set('Accept', 'application/json'),
        observe: 'response',
        withCredentials: true
      }
    );
  }

}
