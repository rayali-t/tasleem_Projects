import { Component } from '@angular/core';
import { User } from './models/user.model';
import { UserService } from './services/user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Expense-Tracker';
  usersParent: Array<User>;

  constructor(userService: UserService) {
   /* let users$: Observable<Array<User>> = userService.getUsers();
    users$.subscribe(users => {
      this.stickiesParent = stickies;
    });*/
  }

  addSticky(user: User) {
    this.usersParent.push(user);
  }
}
