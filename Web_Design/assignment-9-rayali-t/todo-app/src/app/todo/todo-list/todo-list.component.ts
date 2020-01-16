import {Component, OnInit, Input, OnDestroy} from '@angular/core';
import {Subscription} from "rxjs";

import {Item} from "../todo.model";
import {ItemsService} from "../todo.service";

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit,OnDestroy {

  items: Item[] = [];
  private itemSub: Subscription;
itemsService:ItemsService;
//dependency injection
constructor(itemsService: ItemsService) {
  this.itemsService=itemsService;
}

  ngOnInit() {
//subscribe to items
    this.itemsService.list().subscribe((items: Item[]) => {
      this.items = items;
      console.log("We got",items);

      for(var i = 0;i < items.length;i++){
        console.log("We got due dates",items[i].dueDate);}
    });
  }

  viewItemDetails(id:string){
  this.itemsService.viewItem(id).subscribe((item: Item)=>{
    console.log("We got view",item);
    document.getElementById("title").innerText=item.title;
    document.getElementById("desc").innerText=item.description;
    document.getElementById("dueDate").innerText=item.dueDate;
    document.getElementById("time").innerText=item.time;
  });
  }

  markCompleted(item:Item){
    const itemInst :Item={
      _id: item._id,
      title: item.title,
      description: item.description,
      dueDate: item.dueDate,
      time: item.time,
      status: "completed"
    };
    this.itemsService.putItem(itemInst._id,itemInst.title,itemInst.description,itemInst.dueDate,itemInst.time,itemInst.status);


  }

  updateName(event: Event, item: Item) {
    const target: any = event.target;
    const newValue = target.value;
    item.title = newValue;
  }

  ngOnDestroy() {
  this.itemSub.unsubscribe();
  }

}
