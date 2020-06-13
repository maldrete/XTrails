import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Location } from '../entities/location/location';


@Injectable({
  providedIn: 'root'
})

export class LocationService {

  private baseURL = environment.baseUrl + 'location';

  constructor(private http: HttpClient) { }

  getLocation(id: number): Observable<Location> {
    return this.http.get<Location>(this.baseURL + id).pipe(
      catchError((err: any) => {
        console.log('location.service.getLocation(): Error retrieving location');
        console.log(err);
        return throwError(err);
      })
    )
  }


  createLocation(location: Location): Observable<Location> {
    return this.http.post<Location>(this.baseURL, location).pipe(
      catchError((err: any) => {
        console.log('location.service.createLocation(): Error creating location');
        console.log(err);
        return throwError(err);
      })
    )
  }


}
