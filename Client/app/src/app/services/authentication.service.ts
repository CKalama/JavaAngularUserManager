import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse, } from '@angular/common/http';
import {catchError, map} from 'rxjs/operators';
import { Observable, throwError } from 'rxjs'; 
import {Constants} from "../constants";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http:HttpClient) { }

  authenticate(username: | any, password: | any): Observable<any>{
    const body = new HttpParams()
      .set('username', username)
      .set('password', password)

      return this.http.post(Constants.SERVER_URL + 'login', body, {'responseType': 'text'})
        .pipe(
          map(response => {
            localStorage.setItem('user', btoa(username + ":" + password));
          }),
          catchError((err: any | HttpErrorResponse) => {
            return throwError(err);
          })
        )
    }
}
