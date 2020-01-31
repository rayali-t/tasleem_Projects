
// shared files kept in this folder
export class BudgetItem{
    _id: string;
    description: string;
    amount: number;

    constructor(description: string, amount: number) {
        this.description = description;
        this.amount = amount;
    }
}
