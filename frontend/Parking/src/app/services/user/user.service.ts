import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

   /*   ******************** */
  private API_URL = environment.API_URL + "/api/";

  /*   ******************** */
  constructor(private httpClient: HttpClient) { }

  /********* methodes  **********/
  getUser() {
    return this.httpClient.get(this.API_URL + "user",
      {
        headers:  new HttpHeaders()
          .set('Content-Type', 'application/json')
          .set('Accept', 'application/json'),
        withCredentials: true
      }
    );
  }

  creatUser(user){
    return this.httpClient.post(this.API_URL + "user",
    JSON.stringify(user),
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json'),
      withCredentials: true
    });
  }

}
