import { Injectable,Input,Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
// import { Observable } from 'rxjs/Observable';
import { environment } from './../../environments/environment';
import { Subject } from 'rxjs';

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient) { }
    public getLoggedInName = new Subject();
    // @Output() getLoggedInName: EventEmitter<any> = new EventEmitter();
    login(username: string, password: string) {
      console.log('in auth service');
      // console.log(user);
      console.log(username);
      console.log(password);
      return this.http.post<any>(`${environment.serverBaseURL}/users/login`, { username : username, password: password })
            .pipe(map(user => {
                // login successful if there's a jwt token in the response
              console.log('in pipe map');
              console.log(user);
              if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('usertoken', JSON.stringify(user));
                    console.log('logged user token: ' + (localStorage.getItem('usertoken')));
                    this.getLoggedInName.next('LoggedIn');
                }
              return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('usertoken');
    }
}
