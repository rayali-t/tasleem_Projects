import { Component, OnInit } from '@angular/core';
import { BudgetItem } from 'src/shared/models/budget-item.module';
import { UpdateEvent } from '../budget-item-list/budget-item-list.component';
import {NgForm} from '@angular/forms';
import {Chart} from 'chart.js';
import {Expense} from '../models/expense.model';
import {ExpenseService} from '../services/expense.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

  userId: string;
  budgetItems: BudgetItem[] = new Array<BudgetItem>();
  totalBudget: number = 0;
  expenses: Expense[] = [];
  expensesNew: Expense[] = [];

  expenseService: ExpenseService;
  constructor(expenseService: ExpenseService) {
    this.expenseService = expenseService;

    this.userId = JSON.parse(localStorage.getItem('usertoken')).user._id;
  }

  ngOnInit() {

    // subscribe to items
    this.expenseService.getExpenses().subscribe((expenses: Expense[]) => {
      this.expenses = expenses;
      console.log('We got', expenses);

      // tslint:disable-next-line: prefer-for-of
      for (let i = 0; i < expenses.length; i++) {
        if (expenses[i].userId === this.userId) {
          this.budgetItems.push(expenses[i]);
          this.expensesNew.push(expenses[i]);
         // console.log(this.expensesNew[0]);
        //  console.log('We got due dates', expenses[i]._id, expenses[i].description, this.budgetItems[i].expenseId);
        }
      }
      for (let i = 0; i < this.budgetItems.length; i++) {
        console.log('bi yaayyiee');
        console.log(this.budgetItems[i]);
      }
    });

  }
    addItem(newItem: BudgetItem) {
      this.onAddExpense(newItem);
      this.budgetItems.push(newItem);
      this.totalBudget += newItem.amount;
    }
    deleteItem(item: BudgetItem) {
       console.log('in delete');
       console.log(item._id);
       this.expenseService.deleteExpense(item._id).subscribe();
       let index = this.budgetItems.indexOf(item);
       this.budgetItems.splice(index, 1);
       this.totalBudget -= item.amount;

      // this.budgetItems.deleteItem(item).subscribe();

    }
    updateItem(updateEvent: UpdateEvent) {
      this.budgetItems[this.budgetItems.indexOf(updateEvent.old)] = updateEvent.new;
      console.log('in update');
      console.log(updateEvent.old._id);
      const expenseUpd: Expense = {
        _id: updateEvent.old._id,
        userId: this.userId,
        amount: updateEvent.new.amount ,
        description: updateEvent.new.description,
        createDate: undefined,
        modifiedDate: undefined
        // imagepath: imagepath
      };
      this.expenseService.updateExpense(expenseUpd).subscribe();
      // update the total budget
      this.totalBudget -= updateEvent.old.amount;
      this.totalBudget += updateEvent.new.amount;
    }


  onAddExpense(newItem: BudgetItem) {

    // wont allow to enter empty row
    // if(form.invalid){
    // return;
    // }

    // alert('Post added');

    const expense: Expense = {
      _id: undefined,
      userId: this.userId,
      amount: newItem.amount ,
      description: newItem.description,
      createDate: undefined,
      modifiedDate: undefined
    };
    console.log(expense);
    this.expenseService.addExpense2(expense);
    // form.resetForm();
  }

}
