import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { BudgetItem } from 'src/shared/models/budget-item.module';
import {Expense} from '../models/expense.model';
import {ExpenseService} from '../services/expense.service';

@Component({
  selector: 'app-add-item-form',
  templateUrl: './add-item-form.component.html',
  styleUrls: ['./add-item-form.component.scss']
})

export class AddItemFormComponent implements OnInit {

  @Input() item: BudgetItem;
  @Output() formSubmit: EventEmitter<BudgetItem> = new EventEmitter<BudgetItem>();

  userId: string;
  isNewItem: boolean;
  expenseService: ExpenseService;

  constructor(expenseService: ExpenseService) {
    this.userId = JSON.parse(localStorage.getItem('usertoken')).user._id;
    this.expenseService = expenseService;
  }

  ngOnInit() {
    // if item has value
    if (this.item) {
      // this means that an existing item object was passed into this component, therefore this is not a new item
      this.isNewItem = false;
    } else {
      this.isNewItem = true;
      this.item = new BudgetItem('', null);
    }
  }
  onSubmit(form: NgForm) {
    this.formSubmit.emit(form.value);

    console.log('in on submit');
    console.log(this.isNewItem);
   /* if (!this.isNewItem) {
      console.log('in pass');
      // wont allow to enter empty row
      // if(form.invalid){
      // return;
      // }

      alert('Post added');

      const expense: Expense = {
        _id: undefined,
        userId: this.userId,
        amount: this.item.amount ,
        description: this.item.description ,
        createDate: undefined,
        modifiedDate: undefined
      };*/
    //  console.log(expense);
    //  this.expenseService.updateExpense(expense);
      // form.resetForm();
   // }

    form.reset();
  }
}
