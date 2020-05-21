import { User } from '../user/user';
import { zip } from 'rxjs';
import { Trail } from '../trail/trail';

export class Location {
  id: number;
  city: string;
  park: string;
  state: string;
  longitude: number;
  latitude: number;
  county: string;
  street: string;
  zipcode: number;
  trail: Trail;
  user: User;


  constructor(
    id?: number,
    city?: string,
    state?: string,
    longitude?: number,
    latitude?: number,
    county?: string,
    street?: string,
    zipcode?: number,
    trail?: Trail,
    user?: User
  ) {
    this.id = id;
    this.city = city;
    this.state = state;
    this.longitude = longitude;
    this.latitude = latitude;
    this.county = county;
    this.street = street;
    this.zipcode = zipcode;
    this.trail = trail;
    this.user = user;

  }
}
