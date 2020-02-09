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
  constructor(private httpClient: HttpClient) { } // injections des depandances

  /*   ******************** */
  getAllParking(){
    return this.httpClient.get(this.API_URL + "parking", // li jaying f parking
    {
      headers: new HttpHeaders()
      .set('Content-Type', 'application/json') // we to
      .set('Accept', 'application/json'), // we do too accept json
      observe: 'response' // we add it
    }
    );
  }
}
