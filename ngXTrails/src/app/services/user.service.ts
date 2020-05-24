import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Observable, throwError } from 'rxjs';
import { User } from '../entities/user/user';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = environment.baseUrl + 'api/me';

  constructor(private http: HttpClient, private authSvc: AuthService) { }

  // M E T H O D S
  getUser(): Observable<User> {
    const credentials = this.authSvc.getCredentials();

    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };

    return this.http.get<User>(this.baseURL, httpOptions).pipe(
      catchError((err: any) => {
        console.log('user.service.getUser(): Error retrieving user');
        console.log(err);
        return throwError(err);
      })
    )
  }

  updateUser(user: User): Observable<User> {
    const credentials = this.authSvc.getCredentials();

    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Basic ${credentials}`
      })
    };

    return this.http.put<User>(this.baseURL, user, httpOptions).pipe(
      catchError((err: any) => {
        console.log('user.service.updateUser(): Error updating user');
        console.log(err);
        return throwError(err);
      })
    )
  }




}
