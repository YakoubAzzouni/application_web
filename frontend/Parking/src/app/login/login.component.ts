import { Component, OnInit } from '@angular/core';
import { ParkingService } from '../services/parking/parking.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  //ndirou inside ta3 classe parking.service.ts
  constructor(private parkingservice: ParkingService) { }

  ngOnInit(): void {
    this.getAllParking().then((resolve: any) => { //hadi then njibouha m la fonction li ta7t m promise resolve t7atha f then reject t7atha f catch
      console.log(resolve.body);
    }).catch((reject: any) => {
      console.log(reject);
    });
  }
  /* ------------------- */
  getAllParking(){
    let promise = new Promise((resolve, reject) => { // good dans resolve bad dans reject
      this.parkingservice.getAllParking()
      .subscribe((response: any) => { // recup http tradhoum objet
        console.log(response);
        resolve(response);
      },
      err => {
        console.log(err, status);
        reject(err);
    });
  });
  return promise;
}
}
