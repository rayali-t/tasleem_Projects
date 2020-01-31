/**
 * user endpoint route definitions.
 */

'use strict';
module.exports = function (app) {
    const userController = require('../controllers/user-controller');
    const jwtHelper = require('../config/jwtHelper');
    //  Routes to create user
    app.route('/users/register')
        .post(userController.post);

    // user Routes for get, update and delete user.
    app.route('/users/login')
        .post(userController.authenticate);

    app.route('/users/userProfile')
        .get(jwtHelper.verifyJwtToken,userController.userProfile);

    // user Routes for search and create.
    app.route('/users')
        .get(userController.list)
        .post(userController.post);

    //user route for login
    // app.route('/users/login').post(userController.login);

    // user Routes for get, update and delete.
    app.route('/users/:userId')
        .get(userController.get)
        .put(userController.put)
        .delete(userController.delete);
};
