import { Component, OnInit } from '@angular/core';
import { Chart} from 'chart.js';
import {ExpenseService} from '../services/expense.service';
import {Expense} from '../models/expense.model';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss']
})

export class GraphComponent implements OnInit {

  userId: string;
  // budgetItems: Expense[] = new Array<Expense>();
  expenses: Expense[] = [];
  expenseService: ExpenseService;
  income = 0;
  expense = 0;
  constructor(expenseService: ExpenseService) {
    this.expenseService = expenseService;

    this.userId = JSON.parse(localStorage.getItem('usertoken')).user._id;
  }
  PieChart = [];

  ngOnInit() {
    // subscribe to items
    this.expenseService.getExpenses().subscribe((expenses: Expense[]) => {
      this.expenses = expenses;
      console.log('We got', expenses);

      // tslint:disable-next-line: prefer-for-of
      for (let i = 0; i < expenses.length; i++) {
        if (expenses[i].userId === this.userId) {
          console.log(expenses[i]);
          if (expenses[i].amount > 0) {this.income = this.income + expenses[i].amount; } else {
            this.expense = this.expense + expenses[i].amount;
          }
          // console.log(this.expensesNew[0]);
          //  console.log('We got due dates', expenses[i]._id, expenses[i].description, this.budgetItems[i].expenseId);
        }
      }
      console.log('expense');
      console.log(this.expense);
      this.expense =  this.expense * -1;

      this.PieChart = new Chart('pieChart', {
        type: 'pie',
        radius: '2px',
        innerSize: '2px',
        data: {
          labels: ['Income', 'Expenses'],
          datasets: [{
            label: 'Expense tracker',
            data: [this.income, this.expense],
            backgroundColor: [
              'rgba(0, 255, 0, 0.3)',
              'rgba(255, 0,0, 0.6)'
            ],
            borderColor: [
              'black',
              'black'
            ],
            borderWidth: 2

          }]
        },
      });
    });

    console.log('expense new');
    console.log(this.expense);

  }

}
