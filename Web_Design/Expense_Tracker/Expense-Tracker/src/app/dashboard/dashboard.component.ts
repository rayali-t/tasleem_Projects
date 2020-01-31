import { Component, OnInit } from '@angular/core';
import { ExportToCsv } from 'export-to-csv';
import * as jsPDF from 'jspdf';
import {Expense} from "../models/expense.model";
import {ExpenseService} from "../services/expense.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit{

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

  ngOnInit() {
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
    });
  }

    downloadPDF(){
      console.log('downloading');
      const doc = new jsPDF();
      doc.text('Report \n Your Expenses: ' +
        this.expense + '\n Your Income: ' + this.income,15,15);
      doc.save('Report.pdf');

    }

    downloadCSV(){

      var data = [
        {
          Amount: '200',
          Description: 'Food'
        },
        {
          Amount: '200',
          Description: 'Food'
        },
        {
          Amount: '200',
          Description: 'Food'
        }
      ];

      const options = {
          fieldSeparator: ',',
          quoteStrings: '"',
          decimalSeparator: '.',
          showLabels: true,
          showTitle: false,
          title: 'My Awesome CSV',
          useTextFile: false,
          useBom: true,
          useKeysAsHeaders: true,
          filename: 'Report'
          // headers: ['Column 1', 'Column 2', etc...] <-- Won't work with useKeysAsHeaders present!
        };

      const csvExporter = new ExportToCsv(options);

      csvExporter.generateCsv(data);

    }

}
