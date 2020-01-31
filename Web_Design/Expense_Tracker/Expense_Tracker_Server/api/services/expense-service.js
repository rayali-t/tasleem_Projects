/**
 * Service for expenseItem operations.
 */

'use strict';
const mongoose = require('mongoose'),
    Expense = mongoose.model('expense');

/**
 * Returns an array of expenseItem object matching the search parameters.
 *
 * @param {Object} params {Search parameters}
 */
exports.search = function (params) {
    const promise = Expense.find(params).exec();
    return promise;
};

/**
 * Saves and returns the new expenseItem object.
 *
 * @param {Object} expenseItem {Expense object}
 */
exports.save = function (expenseItem) {
    const newExpense = new Expense(expenseItem);
    const promise = newExpense.save();
    return promise;
};

/**
 * Returns the expenseItem object matching the id.
 *
 * @param {string} itemId {Id of the expenseItem object}
 */
exports.get = function (expenseId) {
    const promise = Expense.findById(expenseId).exec();
    return promise
};

//get expenses for a particular user
exports.getUserExpense = function (userId) {
    const promise = Expense.find({"userId": userId}).exec();
    return promise
};

/**
 * Updates and returns the expenseItem object.
 *
 * @param {Object} expenseItem {Expense object}
 */
exports.update = function (expenseItem) {
    //expenseItem.modified_date = new Date();
    // expenseItem.time = new Date();
    const promise = Expense.findOneAndUpdate({_id: expenseItem._id}, expenseItem).exec();
    return promise;
};

/**
 * Deletes the expenseItem object matching the id.
 *
 * @param {string} expenseId {Id of the expenseItem object}
 */
exports.delete = function (expenseId) {
    const promise = Expense.remove({_id: expenseId});
    return promise;
};
