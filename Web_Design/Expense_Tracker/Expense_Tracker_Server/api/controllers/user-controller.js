/**
 * Controller for user endpoints.
 */

'use strict';
//import user service.
const userService = require('../services/user-service');
const passport = require('passport');
//import User from '../models/user';

/**
 * Returns a list of stickies in JSON based on the
 * search parameters.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.list = function (request, response) {
    const resolve = (user) => {
        response.status(200);
        response.json(user);
    };
    userService.search({})
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Creates a new user item with the request JSON and
 * returns user JSON object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.post = function (request, response) {
    const newUser = Object.assign({}, request.body);
    const resolve = (userItem) => {
        response.status(200);
        response.json(userItem);
    };
    userService.save(newUser)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Returns a userItem object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.get = function (request, response) {
    const resolve = (userItem) => {
        response.status(200);
        response.json(userItem);
    };
    userService.get(request.params.userId)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Updates and returns a userItem object in JSON.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.put = function (request, response) {
    const userItem = Object.assign({}, request.body);
    const resolve = (userItem) => {
        response.status(200);
        response.json(userItem);
    };
    userItem._id = request.params.userId;
    userService.update(userItem)
        .then(resolve)
        .catch(renderErrorResponse(response));
};

/**
 * Deletes a userItem object.
 *
 * @param {request} {HTTP request object}
 * @param {response} {HTTP response object}
 */
exports.delete = function (request, response) {
    const resolve = (userItem) => {
        response.status(200);
        response.json({
            message: 'userItem Successfully deleted'
        });
    };
    userService.delete(request.params.userId)
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

exports.login = function (request, response) {

    const newUser = Object.assign({}, request.body);

    //Check username & password
    const resolve = (userItem) => {
        response.status(200);
        response.json(userItem);
    };

    console.log(request);
    console.log(newUser.emailId);

    userService.login(newUser.emailId,newUser.password)
        .then(resolve)
        .catch(renderErrorResponse(response));
};


exports.authenticate = (request,response,next) => {
    passport.authenticate('local', (err, user, info) => {
        // error from passport middleware
        console.log("user in controller");
        console.log(user);
        if (err) {
            console.log("error :"+ err)
            return response.status(400).json(err);
        }

        // registered user
        else if (user) {
            console.log("valid user: "+user);
            return response.status(200).json({ "token": user.generateJwt(), "user":user });
        }
        // unknown user or wrong password
        else return response.status(404).json(info);
    })(request, response);
}

exports.userProfile = (request, response, next) => {
    User.findOne({ _id: request._id },
        (err, user) => {
            console.log("userProfile: " + request.body)
            if (!user)
                return response.status(404).json({ status: false, message: 'User record not found.' });
            else
                return response.status(200).json({ status: true, user : _.pick(user,['emailId']) });
        }
    );
}
