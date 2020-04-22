import { Component, OnInit } from '@angular/core';
import { ParkingService } from 'src/app/services/parking/parking.service';
import { Ville } from 'src/app/models/ville/ville';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-settings-ville',
  templateUrl: './settings-ville.component.html',
  styleUrls: ['./settings-ville.component.css']
})
export class SettingsVilleComponent implements OnInit {

  //********** variable  ********/
  villes: Array<Ville> = new Array();
  ville_edit : Ville = new Ville();
  ville_insertion : Ville = new Ville();
  ville_created : Ville;
  deleted_ville : Ville;
  edited_ville : Ville;

  //********** constructor ********/
  constructor(private parkingService : ParkingService , config: NgbModalConfig, private modalService: NgbModal) {
    config.backdrop = 'static';
    config.keyboard = false;

   }

  ngOnInit() {
    this.getAllVille();
  }

  openCreate(content3){
    this.modalService.open(content3);
  }

  openDelete(content){
    this.modalService.open(content);
  }

  Delete(ville_id){
    this.deleteVille(ville_id).then((response : any) =>{
      this.modalService.dismissAll();
      this.getAllVille();
    });
  }

  Create(){
    this.insertVille(this.ville_insertion).then((response : any) => {
      this.modalService.dismissAll();
      this.getAllVille();
    });
  }



  //***************** methodes *************/

  insertVille(ville){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.insertVille(ville)
      .subscribe((response: any) => {
        console.log(response);
        this.ville_created = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }
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

  deleteVille(ville_id){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.deleteVille(ville_id)
      .subscribe((response: any) => {
        console.log(response);
        this.deleted_ville = response; // response fih jason t9ochi
        resolve(response);
        },
      err => {
        console.log( err.status );
        reject(err);
       });
     });
     return promise;
  }

  editVille(ville_id, ville){
    let promise = new Promise((resolve, reject) =>{
      this.parkingService.editVille(ville_id, ville)
      .subscribe((response: any) => {
        console.log(response);
        this.edited_ville = response; // response fih jason t9ochi
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
