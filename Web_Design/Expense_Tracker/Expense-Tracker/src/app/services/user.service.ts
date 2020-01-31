import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './../models/user.model';
import { environment } from './../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class UserService {
  private users: User[] = [];
  userResource: string;
  userResourceURL: string;

  /**
   * Constructor.
   */
  constructor(private http: HttpClient) {
    this.userResource = 'user';
    this.userResourceURL = `${environment.serverBaseURL}/${this.userResource}`;
  }

  /**
   * Returns all users.
   *
   * @return {Observable<Array<User>>} {Observable user array of users}
   */
  getUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>(this.userResourceURL);
  }

  /**
   * Creates new user.
   *
   * @param  {User} user: User {new user object}
   * @return {Observable<User>} {Observable for saved user object}
   */

  createUser(user: User) {
    this.createUser1(user)
    // tslint:disable-next-line:no-shadowed-variable
      .subscribe(user => {this.users.push(user); // push adds item to array of users
      });
  }

  createUser1(user: User = null): Observable<User> {
    let newUser: User;
    // @ts-ignore
    newUser = user;
   // newUser = user ? user : {_id: '',
   // email: 'Untitled Sticky',
   // password: 'testPWD'};
    console.log(newUser);
    return this.http.post<User>(this.userResourceURL, newUser);
  }
}
