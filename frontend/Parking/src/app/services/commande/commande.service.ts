import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

   /*   ******************** */
   private API_URL = environment.API_URL + "/commande-service/";

   /*   ******************** */
   constructor(private httpClient: HttpClient) { }

   /* ***************** */

   getAllClients(){
     return this.httpClient.get(this.API_URL + "client",
     {
       headers: new HttpHeaders()
       .set('Content-Type', 'application/json')
       .set('Accept', 'application/json'),
       withCredentials: true
     }
     );
   }

   insertClient(client){
     return this.httpClient.post(this.API_URL + "client",
     JSON.stringify(client), // nzidouha f post
     {
       headers: new HttpHeaders()
       .set('Content-Type', 'application/json')
       .set('Accept', 'application/json'),
       withCredentials: true
     }
     );
   }

   getAllReservations(){
    return this.httpClient.get(this.API_URL + "reservation",
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json'),
      withCredentials: true
    }
    );
  }

  insertReservation(reservation){
    return this.httpClient.post(this.API_URL + "reservation",
    JSON.stringify(reservation), // nzidouha f post
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json'),
      withCredentials: true
    }
    );
  }

  getByDate(date_in, date_out){
    return this.httpClient.get(this.API_URL + "reservation/get?dateIn=" + date_in + "&dateOut=" + date_out,
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json'),
      withCredentials: true
    }
    );
  }
}
