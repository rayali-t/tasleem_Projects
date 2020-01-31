import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { BudgetItem } from 'src/shared/models/budget-item.module';
import { MatDialog } from '@angular/material';
import { EditItemModalComponent } from '../edit-item-modal/edit-item-modal.component';
import {ExpenseService} from '../services/expense.service';
import {Expense} from '../models/expense.model';

@Component({
  selector: 'app-budget-item-list',
  templateUrl: './budget-item-list.component.html',
  styleUrls: ['./budget-item-list.component.scss']
})

export class BudgetItemListComponent implements OnInit {

  @Input() budgetItems: BudgetItem[];
  @Output() delete: EventEmitter<BudgetItem> = new EventEmitter<BudgetItem>();
  @Output() update: EventEmitter<UpdateEvent> = new EventEmitter<UpdateEvent>();

  expenseService: ExpenseService;

  constructor(public dialog: MatDialog, expenseService: ExpenseService) {
    this.expenseService = expenseService;
  }

  ngOnInit() {
    // subscribe to expenses
    // this.expenseService.getExpenses().subscribe((expense: Expense[]) => {
      // this.expense = expense;
      // console.log("We got",items);

      // for(var i = 0;i < items.length;i++){
        // console.log("We got due dates",items[i].dueDate);}
    // });
  }

  onDeleteButtonClicked(item: BudgetItem) {
    this.delete.emit(item);
  }

  onCardClicked(item: BudgetItem) {
    // show the edit modal
    const dialogRef = this.dialog.open(EditItemModalComponent, {
      width: '580px',
      data: item
    });
    dialogRef.afterClosed().subscribe(result => {
      // Check if result has a value
      if(result) { // result is updated budget item
       this.update.emit({
           old: item,
           new: result
         });
      }
    });
  }
}
export interface UpdateEvent {
  old: BudgetItem;
  new: BudgetItem;
}
