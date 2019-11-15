/**
 * Controller for todo endpoints.
 */

'use strict';
//import todo service.
const todoService = require('../services/todo-service');
/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.list = function (request, response) {
    const resolve = (todo) => {
        response.status(200);
        response.json(todo);
    };
    todoService.search({})
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Creates a new todo item with the request JSON and
 * returns todo JSON object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.post = function (request, response) {
    const newItem = Object.assign({}, request.body);
    const resolve = (todoItem) => {
        response.status(200);
        response.json(todoItem);
    };
    todoService.save(newItem)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Returns a todoItem object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function (request, response) {
    const resolve = (todoItem) => {
        response.status(200);
        response.json(todoItem);
    };
    todoService.get(request.params.itemId)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Updates and returns a todoItem object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.put = function (request, response) {
    const todoItem = Object.assign({}, request.body);
    const resolve = (todoItem) => {
        response.status(200);
        response.json(todoItem);
    };
    todoItem._id = request.params.itemId;
    todoService.update(todoItem)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Deletes a todoItem object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.delete = function (request, response) {
    const resolve = (todoItem) => {
        response.status(200);
        response.json({
            message: 'todoItem Successfully deleted'
        });
    };
    todoService.delete(request.params.itemId)
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
