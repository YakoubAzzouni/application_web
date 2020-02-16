import { Component, OnInit} from '@angular/core';
import { ParkingService } from 'src/app/services/parking/parking.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Parking } from 'src/app/models/parking/parking';
import { Ville } from 'src/app/models/ville/ville';


@Component({
  selector: 'app-parkings',
  templateUrl: './parkings.component.html',
  styleUrls: ['./parkings.component.css'],
  providers: [NgbModalConfig, NgbModal]
})

export class ParkingsComponent implements OnInit {

  // ***** variables *****
  parkings: Array<Parking> = new Array();
  villes: Array<Ville> = new Array();
  parking_insertion: Parking = new Parking();
  ville_insertion: Ville = new Ville();

  inserted_parking: Parking;
  deleted_parking: Parking;
  edited_parking: Parking;
  inserted_ville: Ville;

  //**** constructeur *****
  constructor(private parkingService: ParkingService, config: NgbModalConfig, private modalService: NgbModal){
    config.backdrop = 'static';
    config.keyboard = false;
   }

   // modale pop up
   openDelete(content) {
    this.modalService.open(content);
  }

  openEdit(content1){
    this.modalService.open(content1)
  }

  openAdd(content2){
    this.modalService.open(content2)
  }


  ngOnInit() {
    this.getAllParking();
    this.getAllVille();
  }

  /******  Methodes  ************/

// pop off de delete
  Delete(parking_id){
    this.deleteParking(parking_id).then((response: any)=>{
      this.modalService.dismissAll();  // after deleting parking close model
      this.getAllParking(); // besh n3awad njib les parking
     });
  }

  Add(){
    this.insertVille(this.ville_insertion).then((response: any) =>{
      this.parking_insertion.ville = response;
      this.insertParking(this.parking_insertion).then((response1: any) =>{
        this.modalService.dismissAll();
        this.getAllParking();
      })
    });
  }
  /******* methode for parking  ********/
  getAllParking(){
    let promise = new Promise((resolve, reject) => {
      this.parkingService.getAllParking()
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
 // delete parking
  deleteParking(parking_id){
    let promise = new Promise((resolve, reject) => {
      this.parkingService.deleteParking(parking_id)
     .subscribe((response: any) => {
       console.log(response);
       this.deleted_parking = response; // response fih jason t9ochi
       resolve(response);
       },
     err => {
       console.log(  err.status );
       reject(err);
      });
    });
    return promise;
  }

  EditParking(parking_id){
    let promise = new Promise((resolve, reject) => {
      this.parkingService.updateParking(parking_id)
     .subscribe((response: any) => {
       console.log(response);
       this.edited_parking = response; // response fih jason t9ochi
       resolve(response);
       },
     err => {
       console.log( err.status );
       reject(err);
      });
    });
    return promise;
  }

  insertParking(parking){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.insertParking(parking)
      .subscribe((response: any) => {
        console.log(response);
        this.inserted_parking = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }


 /***** methode  for ville  ******/
  getAllVille(){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.getAllVille()
      .subscribe((response: any) => {
        console.log(response);
        this.villes = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }

  insertVille(ville)
  {
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.insertVille(ville)
      .subscribe((response: any) => {
        console.log(response);
        this.inserted_ville = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }


}
