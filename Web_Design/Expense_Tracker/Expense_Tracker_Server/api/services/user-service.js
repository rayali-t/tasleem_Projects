/**
 * Service for userItem operations.
 */

'use strict';
const mongoose = require('mongoose'),
    User = mongoose.model('user');

/**
 * Returns an array of userItem object matching the search parameters.
 *
 * @param {Object} params {Search parameters}
 */
exports.search = function (params) {
    const promise = User.find(params).exec();
    return promise;
};

/**
 * Saves and returns the new userItem object.
 *
 * @param {Object} userItem {User object}
 */
exports.save = function (userItem) {
    const newUser = new User(userItem);
    const promise = newUser.save();
    return promise;
};

/**
 * Returns the userItem object matching the id.
 *
 * @param {string} itemId {Id of the userItem object}
 */
exports.get = function (userId) {
    const promise = User.findById(userId).exec();
    return promise
};

/**
 * Updates and returns the userItem object.
 *
 * @param {Object} userItem {User object}
 */
exports.update = function (userItem) {
    //userItem.modified_date = new Date();
    // userItem.time = new Date();
    const promise = User.findOneAndUpdate({_id: userItem._id}, userItem).exec();
    return promise;
};

/**
 * Deletes the userItem object matching the id.
 *
 * @param {string} userId {Id of the userItem object}
 */
exports.delete = function (userId) {
    const promise = User.remove({_id: userId});
    return promise;
};

exports.login = function (email,password) {

    //const promise = User.findById({_id: userItem._id}).exec();
    //return promise;
     let user = User.findOne({email: email});
    if (user) {
         if (user.password === password) {
             //return promise;
             console.log("user found");
        } else {
             // error invalid password
             console.log("invalid pwd");
         }
     } else {
        //error user not found
        console.log(" user not found");
     }
}
