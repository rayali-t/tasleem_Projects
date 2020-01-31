/**
 * Controller for expense endpoints.
 */

'use strict';
//import expense service.
const expenseService = require('../services/expense-service');
/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.list = function (request, response) {
    const resolve = (expense) => {
        response.status(200);
        response.json(expense);
    };
    expenseService.search({})
        .then(resolve)
        .catch(renderErrorResponse(response));
};


exports.listUserExpense = function (request, response) {
    const resolve = (expense) => {
        response.status(200);
        response.json(expense);
    };
    expenseService.getUserExpense(request)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Creates a new expense item with the request JSON and
 * returns expense JSON object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.post = function (request, response) {
    const newExpense = Object.assign({}, request.body);
    const resolve = (expenseItem) => {
        response.status(200);
        response.json(expenseItem);
    };
    expenseService.save(newExpense)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Returns a expenseItem object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function (request, response) {
    const resolve = (expenseItem) => {
        response.status(200);
        response.json(expenseItem);
    };
    expenseService.get(request.params.expenseId)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Updates and returns a expenseItem object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.put = function (request, response) {
    const expenseItem = Object.assign({}, request.body);
    const resolve = (expenseItem) => {
        response.status(200);
        response.json(expenseItem);
    };
    expenseItem._id = request.params.expenseId;
    expenseService.update(expenseItem)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Deletes a expenseItem object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.delete = function (request, response) {
    const resolve = (expenseItem) => {
        response.status(200);
        response.json({
            message: 'expenseItem Successfully deleted'
        });
    };
    expenseService.delete(request.params.expenseId)
        .then(resolve)
        .catch(renderErrorResponse(response));
};
/**
 * Throws error if error object is present.
 *
 * @param {Response} response The response object
 * @return {Function} The error handler function.
 */
let renderErrorResponse = (response) => {
    const errorCallback = (error) => {
        if (error) {
            response.status(500);
            response.json({
                message: error.message
            });
        }
    }
    return errorCallback;
};
