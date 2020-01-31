import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {UserService} from '../services/user.service';
import { User } from './../models/user.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  userService: UserService;
  constructor(userService: UserService) {

    this.userService = userService;
  }

  ngOnInit() {
  }
  onSignup(form: NgForm) {
// not used anymore!!!**IMP
    // wont allow to enter empty row
    // if(form.invalid){
    // return;
    // }

    alert('Post added');

    const user: User = {
      id: form.value.id,
     // emailId: form.value.email,
     // password: form.value.password
    //  id: number;
    username: form.value.email,
    password: form.value.email,
    firstName: form.value.email,
    lastName: form.value.email,
    emailId: form.value.email
    };
    console.log(user);
    this.userService.createUser(user);
    form.resetForm();
  }
}
