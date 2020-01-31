import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Expense } from './../models/expense.model';
import { environment } from './../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class ExpenseService {
  private expenses: Expense[] = [];
  expenseResource: string;
  expenseResourceURL: string;

  /**
   * Constructor.
   */
  constructor(private http: HttpClient) {
    this.expenseResource = 'expenses';
    this.expenseResourceURL = `${environment.serverBaseURL}/${this.expenseResource}`;
  }

  /**
   * Returns all expenses.
   *
   * @return {Observable<Array<Expense>>} {Observable expense array of expenses}
   */
  getExpenses(): Observable<Array<Expense>> {
    // return this.http.get<Array<Expense>>(`${this.expenseResourceURL}/${userID}`);
    return this.http.get<Array<Expense>>(this.expenseResourceURL);
  }

  /**
   * Creates new expense.
   *
   * @param  {Expense} expense: Expense {new expense object}
   * @return {Observable<Expense>} {Observable for saved expense object}
   */

  addExpense2(expense: Expense) {
    this.addExpense1(expense)
    // tslint:disable-next-line:no-shadowed-variable
      .subscribe(expense => {this.expenses.push(expense); // push adds item to array of expenses
      });
  }

  addExpense1(expense: Expense = null): Observable<Expense> {
    let newExepense: Expense;
    newExepense = expense;
    console.log('in expense service yaaayieee');
    console.log(newExepense);
    return this.http.post<Expense>(this.expenseResourceURL, newExepense);
  }

  addExpense( userId, amount, description, imagepath) {
    const expense = {
      userId: userId,
      amount: amount ,
      description: description,
     // imagepath: imagepath
    };
    return this.http.post(this.expenseResourceURL, expense);
  }

  updateExpense( expense: Expense = null) {
    console.log('in update expense service');
    console.log(`${expense._id}`);
    return this.http.put(`${this.expenseResourceURL}/${expense._id}`, expense);
  }

  deleteExpense(id) {
    console.log(`${this.expenseResourceURL}/${id}`);
    return this.http.delete(`${this.expenseResourceURL}/${id}`);
  }
}
