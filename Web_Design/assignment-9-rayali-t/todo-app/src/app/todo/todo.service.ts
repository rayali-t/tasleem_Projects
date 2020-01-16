import {Item} from "./todo.model";
import {Injectable} from "@angular/core";
import {Observable, Subject} from 'rxjs';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({providedIn: 'root'})
export class ItemsService{
  private items: Item[]=[];
private itemsUpdated = new Subject<Item[]>();

  constructor(private http:HttpClient) {

  }

  //service to fetch list of data on load
  public list(): Observable<Array<Item>> {
    const todoItems$ = this.http.get<Item[]>('http://localhost:3001/todo/');//api/todo
    return todoItems$;
  }

public addTodo(item : Item){
    var headers = new HttpHeaders();
    headers.append('Content-Type','application/json');
    const jsonString=JSON.stringify(item);
   const json= JSON.parse(jsonString);
   console.log(json);
    return this.http.post<Item>('http://localhost:3001/todo/',json);
    //  .map(res=>res.json);
}

    addItem(_id:string, title:string, description:string, dueDate: string, time: string,status: string){
  const item: Item ={_id:_id, title:title, description:description, dueDate: dueDate, time: time, status: status};
   // const item = {title:title};
    console.log("Helooooooo : "+item.status);

   // this.http.post('http://localhost:3001/todo/',item);
    this.addTodo(item)
        .subscribe(item=> {this.items.push(item);//push adds item to array of items
      });
  }

  //service method for viewing a particular todo item
  viewItem(id: string): Observable<Item> {
    const url = `http://localhost:3001/todo/${id}`;
    const todoItem$=  this.http.get<Item>(url);
    return todoItem$;
  }

  //service for marking todo item complete
  completeItem(item: Item): Observable<Item> {
  /*  const url = `http://localhost:3001/todo/${id}`;
    const todoItemget$=  this.http.get<Item>(url);
    //const todoItem$=  this.http.put<Item>(url,todoItemget$);
    return todoItemget$;
*/

    var headers = new HttpHeaders();
    headers.append('Content-Type','application/json');
    const jsonString=JSON.stringify(item);
    const json= JSON.parse(jsonString);
    console.log(json);
    var idPut=item._id;
    const url =  `http://localhost:3001/todo/${idPut}`;
    return this.http.put<Item>(url,json);
    //  .map(res=>res.json);
  }

  putItem(_id:string, title:string, description:string, dueDate: string, time: string,status: string){
   // var headers = new Headers();
    //headers.append("Access-Control-Allow-Methods", "*");
    console.log(status);
    //console.log(item);
    const item: Item ={_id:_id, title:title, description:description, dueDate: dueDate, time: time, status: status};
    var idPut=item._id;
    console.log(idPut.valueOf());
    const url =  `http://localhost:3001/todo/${idPut}`;
    const jsonString=JSON.stringify(item);
    const json= JSON.parse(jsonString);
    console.log(json);
    console.log(url);
     //  this.http.put(url,json,{ headers: headers});
    this.completeItem(item)
      .subscribe(item=> {this.items.push(item);//push adds item to array of items
      });
  }

  deleteItem(id: number): Observable<{}> {
    const url = `http://localhost:3001/todo/${id}`;
    return this.http
      .delete(url);
  }
}
