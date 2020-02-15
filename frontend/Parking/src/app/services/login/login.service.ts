import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient , HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
   /*   ******************** */
   private API_URL = environment.API_URL + "/api/";

   /*   ******************** */
   constructor(private httpClient: HttpClient) { }

   /********* methodes  **********/
    getAllUsers(){
      return this.httpClient.get(this.API_URL + "user",
       {
        headers: new HttpHeaders()
        .set('Content-Type', 'application/json')
        .set('Accept', 'application/json')
      });
    }
}
