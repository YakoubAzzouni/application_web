import { Component, OnInit, Inject} from '@angular/core';
import { ParkingService } from 'src/app/services/parking/parking.service';
import { NgbModalConfig, NgbModal, NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { Parking } from 'src/app/models/parking/parking';
import { Ville } from 'src/app/models/ville/ville';
import { SESSION_STORAGE, StorageService } from 'angular-webstorage-service';
import { CommandeService } from 'src/app/services/commande/commande.service';
import { Reservation } from 'src/app/models/reservation/reservation';
import { Client } from 'src/app/models/client/client';
import { Router } from '@angular/router';



@Component({
  selector: 'app-parkings',
  templateUrl: './parkings.component.html',
  styleUrls: ['./parkings.component.css'],
  providers: [NgbModalConfig, NgbModal]
})

export class ParkingsComponent implements OnInit {

  // ***** variables *****
  parkings: Array<Parking> = new Array();
  parkings_for_ville: Array<Parking> = new Array();
  inserted_parking: Parking;
  deleted_parking: Parking;
  edited_parking: Parking;
  parking_insertion: Parking = new Parking();


  villes: Array<Ville> = new Array();
  villeById : Ville = new Ville();
  ville_insertion: Ville = new Ville();
  inserted_ville: Ville;
  selected_ville: Ville;
  selected_ville_search: Ville;
  city : String;

  // ***** modal reservation *****
  date_in : Date;
  date_out : Date;
  inserted_reservation : Reservation;
  inserted_client : Client;
  reservation_insertion : Reservation = new Reservation();
  client_insertion : Client = new Client();

  control : boolean = false;
  none : boolean = false;


  //**** constructeur *****
  constructor(private parkingService: ParkingService, config: NgbModalConfig, private modalService: NgbModal,
               @Inject(SESSION_STORAGE) private storage: StorageService, private router: Router,
               private commandeService: CommandeService,  private config_date: NgbDatepickerConfig){
    config.backdrop = 'static';
    config.keyboard = false;


    const currentDate = new Date();

    config_date.minDate = {year:currentDate.getFullYear(), month:currentDate.getMonth()+1, day: currentDate.getDate()};
    config_date.maxDate = {year: 2099, month: 12, day: 31};

    config_date.outsideDays = 'hidden';
   }

   // modale pop up
   openDelete(content) {
    this.modalService.open(content);
  }

  openEdit(content1){
    this.modalService.open(content1);
  }

  openAdd(content2){
    this.modalService.open(content2);
  }

  openReservation(content3){
    this.modalService.open(content3);
  }


  ngOnInit() {
   this.getAllParking();
    this.getAllVille();
    console.log(this.villes);
  }

  get sessionInfo(){
    return this.storage.get("session");
  }


  /******  Methodes  ************/

// pop off the delete
  Delete(parking_id){
    this.deleteParking(parking_id).then((response: any)=>{
      this.modalService.dismissAll();  // after deleting parking close model
      this.getAllParking(); // besh n3awad njib les parking
     });
  }

  Add(){
    this.getVilleById(this.selected_ville).then((response: any) =>{
      this.parking_insertion.ville = response;
      this.insertParking(this.parking_insertion).then((response1: any) =>{
        this.modalService.dismissAll();
        this.getAllParking();
      })
    });
  }

  Edit(parking_id){
    this.getVilleById(this.selected_ville).then((response: any) =>{
      this.parking_insertion.ville = response;
      this.EditParking(parking_id,this.parking_insertion).then((response1: any) =>{
        this.modalService.dismissAll();
        this.getAllParking();
      })
    });
  }

  Search(){
    this.getParkingsForVille(this.selected_ville_search);
    this.parkings = this.parkings_for_ville;
    if(this.parkings.length == 0){ this.none = true;}
  }

  Reserver(parking_id){

    this.insertClient(this.client_insertion).then((response: any) =>{
      this.reservation_insertion.client = response;
      this.reservation_insertion.parking_id = parking_id;
      this.reservation_insertion.date_in = this.formatDate_picker(this.date_in);
      this.reservation_insertion.date_out = this.formatDate_picker(this.date_out);
      console.log(this.reservation_insertion);
      this.insertReservation(this.reservation_insertion).then((response1: any) =>{
        this.modalService.dismissAll();
        this.control = true;
      })
    });
  }

  Done(){

      this.control = false;
      this.router.navigate(['/home']);
  }

  /********************************* methode for parking  ******************************************************/
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

  EditParking(parking_id, parking){
    let promise = new Promise((resolve, reject) => {
      this.parkingService.updateParking(parking_id, parking)
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


 /******************************** methode  for ville  ********************************/
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



  getVilleById(ville_id){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.getVilleById(ville_id)
      .subscribe((response: any) => {
        console.log(response);
        this.villeById = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }

  getParkingsForVille(ville_id){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.getParkingsForVille(ville_id)
      .subscribe((response: any) => {
        console.log(response);
        this.parkings_for_ville = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }

  /********************************* methode for reservation  ******************************************************/
  insertReservation(reservation){
    let promise = new Promise((resolve, reject) =>{
      this.commandeService.insertReservation(reservation)
      .subscribe((response: any) => {
        console.log(response);
        this.inserted_reservation = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }

  /********************************* methode for client ******************************************************/
  insertClient(client){
    let promise = new Promise((resolve, reject) =>{
      this.commandeService.insertClient(client)
      .subscribe((response: any) => {
        console.log(response);
        this.inserted_client = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }

  //******* edit the date format *****************/
  formatDate_picker(dt){
    return `${
      dt.year.toString().padStart(4, '0')}-${
      dt.month.toString().padStart(2, '0')}-${
      dt.day.toString().padStart(2, '0')}`;

  }

}
