import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient , HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ParkingService {
  /*   ******************** */
  private API_URL = environment.API_URL + "/api/";

  /*   ******************** */
  constructor(private httpClient: HttpClient) { }

  /********* methodes  **********/

  getAllParking(){
    return this.httpClient.get(this.API_URL + "parking",
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
    }
    );
  }

  deleteParking(parking_id){
    return this.httpClient.delete(this.API_URL + "parking/"+parking_id,
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
    }
    );
  }

  updateParking(parking_id){
    return this.httpClient.put(this.API_URL + "parking/"+parking_id,
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
    }
    );
  }

  insertParking(parking){
    return this.httpClient.post(this.API_URL + "/parking",
    JSON.stringify(parking), // nzidouha f post
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
    }
    );
  }
  /****** methode de ville *****/
  getAllVille(){
    return this.httpClient.get(this.API_URL + "ville",
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
    }
    );
  }

  insertVille(ville){
    return this.httpClient.post(this.API_URL + "/ville",
    JSON.stringify(ville), // nzidouha f post
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
    }
    );
  }
}
