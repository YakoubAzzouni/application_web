import { Component, OnInit } from '@angular/core';
import { ParkingService } from 'src/app/services/parking/parking.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-parkings',
  templateUrl: './parkings.component.html',
  styleUrls: ['./parkings.component.css'],
  providers: [NgbModalConfig, NgbModal]
})

export class ParkingsComponent implements OnInit {

  // ***** variables *****
  parkings: Array<any> = new Array();
  test: any;
  deleted: any;
  updated: any;
  //**** constructeur *****
  constructor(private homeService: ParkingService, config: NgbModalConfig, private modalService: NgbModal){
    config.backdrop = 'static';
    config.keyboard = false;
   }

   // modale
   open(content) {
    this.modalService.open(content);
  }


  ngOnInit() {
    this.getAllParking();
  }

  /******  Methodes  ************/
  getAllParking(){

    let promise = new Promise((resolve, reject) => {
      this.homeService.getAllParking()
     .subscribe((response: any) => {
       console.log(response);
       this.parkings = response; // response fih jason t9ochi
       resolve(response);
       },
     err => {
       console.log(  err.status );
       reject(err);
      });
    });
    return promise;
  }

  Delete(parking_id){
    this.deleteParking(parking_id).then((response: any)=>{
      this.modalService.dismissAll();  // after deleting parking close model
      this.getAllParking(); // besh n3awad njib les parking
     });
  }
 // delete parking
  deleteParking(parking_id){
    let promise = new Promise((resolve, reject) => {
      this.homeService.deleteParking(parking_id)
     .subscribe((response: any) => {
       console.log(response);
       this.deleted = response; // response fih jason t9ochi
       resolve(response);
       },
     err => {
       console.log(  err.status );
       reject(err);
      });
    });
    return promise;
  }

  updateParking(parking_id){
    let promise = new Promise((resolve, reject) => {
      this.homeService.updateParking(parking_id)
     .subscribe((response: any) => {
       console.log(response);
       this.deleted = response; // response fih jason t9ochi
       resolve(response);
       },
     err => {
       console.log(  err.status );
       reject(err);
      });
    });
    return promise;
  }

}
