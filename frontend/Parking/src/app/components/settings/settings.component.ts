import { Component, OnInit, PipeTransform } from '@angular/core';
import { CommandeService } from 'src/app/services/commande/commande.service';
import { Reservation } from 'src/app/models/reservation/reservation';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  show : boolean = false;
  none : boolean = false;
  reservations: Array<Reservation> = new Array();
  date_in : Date;
  date_out : Date;

  date_in_final : String;
  date_out_final : String;

  constructor(private commandeService : CommandeService,  private config_date: NgbDatepickerConfig) {
    const currentDate = new Date();

    config_date.maxDate = {year: 2099, month: 12, day: 31};

    config_date.outsideDays = 'hidden';
   }

  ngOnInit() {

  }

  formatDate_picker(dt){
    return `${
      dt.year.toString().padStart(4, '0')}-${
      dt.month.toString().padStart(2, '0')}-${
      dt.day.toString().padStart(2, '0')}`;

  }

  Show(){
    if((this.date_in != null) && (this.date_out != null)){
      this.date_in_final = this.formatDate_picker(this.date_in);
    this.date_out_final = this.formatDate_picker(this.date_out);
    this.getByDate(this.date_in_final, this.date_out_final).then((response : any) => {
      console.log(this.reservations);
      if(this.reservations.length == 0){
        this.none = true;
      }
      else {
        this.none = false;
        this.show = true;
      }
    });
   }
  }

  getByDate(date_in,date_out){
      let promise = new Promise((resolve, reject) =>{
        this.commandeService.getByDate(date_in, date_out)
        .subscribe((response: any) => {
          console.log(response);
          this.reservations = response; // response fih jason t9ochi
          resolve(response);
          },
        err => {
          console.log( err.status );
          reject(err);
         });
       });
       return promise;
  }

  getAllReservations(){
    let promise = new Promise((resolve, reject) =>{
      this.commandeService.getAllReservations()
      .subscribe((response: any) => {
        console.log(response);
        this.reservations = response; // response fih jason t9ochi
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
