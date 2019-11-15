/**
 * Service for todoItem operations.
 */

'use strict';
const mongoose = require('mongoose'),
    Todo = mongoose.model('todo');

/**
 * Returns an array of todoItem object matching the search parameters.
 *
 * @param {Object} params {Search parameters}
 */
exports.search = function (params) {
    const promise = Todo.find(params).exec();
    return promise;
};

/**
 * Saves and returns the new todoItem object.
 *
 * @param {Object} todoItem {Todo object}
 */
exports.save = function (todoItem) {
    const newTodo = new Todo(todoItem);
    const promise = newTodo.save();
    return promise;
};

/**
 * Returns the todoItem object matching the id.
 *
 * @param {string} itemId {Id of the todoItem object}
 */
exports.get = function (itemId) {
    const promise = Todo.findById(itemId).exec();
    return promise
};

/**
 * Updates and returns the todoItem object.
 *
 * @param {Object} todoItem {Todo object}
 */
exports.update = function (todoItem) {
    todoItem.modified_date = new Date();
    const promise = Todo.findOneAndUpdate({_id: todoItem._id}, todoItem).exec();
    return promise;
};

/**
 * Deletes the todoItem object matching the id.
 *
 * @param {string} itemId {Id of the todoItem object}
 */
exports.delete = function (itemId) {
    const promise = Todo.remove({_id: itemId});
    return promise;
};
