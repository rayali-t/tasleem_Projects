import {Component, EventEmitter, OnInit, Output} from '@angular/core';

import { Item} from "../todo.model";
import { NgForm } from "@angular/forms"
import {ItemsService} from "../todo.service";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

//@Output() itemCreated = new EventEmitter<Item>();//data emitted of type Item
  //public omits the writing of this.attribute = attribute
  //constructor(public itemService:ItemsService) { }
  itemsService:ItemsService;
//dependency injection
  constructor(itemsService: ItemsService) {
    this.itemsService=itemsService;
  }

  ngOnInit() {
  }
//method trigger on click of add Todo item
  onAddPost(form: NgForm){

    //wont allow to enter empty row
   // if(form.invalid){
     // return;
   // }

    alert("Post added");

    const item :Item={
      _id:"",
      title: form.value.title,
      description: form.value.description,
      dueDate: form.value.dueDate,
      time: form.value.time,
      status:"pending"
    };
    this.itemsService.addItem(form.value.id,form.value.title,form.value.description,form.value.dueDate,form.value.time,"pending");
    form.resetForm();
  }
}
