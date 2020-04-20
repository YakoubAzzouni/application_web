import { Client } from '../client/client';

export class Reservation {
  date_in?: String;
  date_out?: String;
  parking_id?: String;
  client?: Client;
}
