import { Component, OnInit, Inject } from '@angular/core';
import { BudgetItem } from 'src/shared/models/budget-item.module';
import {  MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-edit-item-modal',
  templateUrl: './edit-item-modal.component.html',
  styleUrls: ['./edit-item-modal.component.scss']
})
export class EditItemModalComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<EditItemModalComponent>, 
    @Inject(MAT_DIALOG_DATA) public item: BudgetItem) { }

  ngOnInit() {
  }

  onSubmitted(updatedItem: BudgetItem){      //Return Budget Item on submit
    this.dialogRef.close(updatedItem); 
  }

}
