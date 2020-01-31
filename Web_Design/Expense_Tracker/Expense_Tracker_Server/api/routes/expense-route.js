/**
 * Expense endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const expenseController = require('../controllers/expense-controller');
    // Expense Routes for search and create.
    app.route('/expenses')
        .get(expenseController.list)
        .post(expenseController.post);

    // Expense Routes for get, update and delete.
    app.route('/expenses/:expenseId')
        .get(expenseController.get)
        .put(expenseController.put)
        .delete(expenseController.delete);

    app.route('/expenses/user/:userId')
        .get(expenseController.listUserExpense);
};
