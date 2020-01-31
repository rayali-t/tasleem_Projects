import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { User } from './../models/user.model';
// import { ConnectiontoAPI } from 'src/ConnectiontoAPI';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.serverBaseURL}/users`);
    }

    getById(id: string) {
        console.log('user service' + id);
        return this.http.get(`${environment.serverBaseURL}/users/userProfile`, { headers: { Authorization: `Bearer ${id}` }});
    }

    register(user: User) {
      console.log('in service register');
      console.log(user);
      return this.http.post(`${environment.serverBaseURL}/users/register`, user);
    }

    update(id: string, user: User) {
      console.log('in upd user service');
      console.log(id);
      return this.http.put(`${environment.serverBaseURL}/users/${id}`, user);
    }

    delete(id: number) {
        return this.http.delete(`${environment.serverBaseURL}/users/` + id);
    }
}
