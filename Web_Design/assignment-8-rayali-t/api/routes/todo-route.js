/**
 * Todo endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const todoController = require('../controllers/todo-controller');
    // Todo Routes for search and create.
    app.route('/todo')
        .get(todoController.list)
        .post(todoController.post);

    // Todo Routes for get, update and delete.
    app.route('/todo/:itemId')
        .get(todoController.get)
        .put(todoController.put)
        .delete(todoController.delete);
};
