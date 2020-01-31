'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const bcrypt = require('bcryptjs');
var jwt = require('jsonwebtoken');

/**
 * Mongoose schema for user object.
 */
let userSchema = new Schema({
        firstName: {
            type: String,
            required: 'First name can\'t be empty'
        },
        lastName: {
            type: String
        },
        username: {
            type: String,
            unique : true,  //sets the field as uniques throughout
            required: 'Username can\'t be empty'
        },
    /**
     * username of the user
     */
    emailId: {
        type: String,
        required: true
    },
    /*userName: {
        type: String,
        required: true
    },*/
    /**
     * firstName of the user
     */
    /*firstName: {
        type: String,
        required: "firstName is required"
    },*/
    /**
     * lastName of the user
     */
    /*lastName: {
        type: String
    },*/
    /**
     * userPassword amount
     */
    password: {
        type: String,
        required: "password is required"
    },
    /**
     * user  created date.
     */
    createDate: {
        type: Date,
        default: Date.now
    },

    /**
     * Last modified date.
     */
    modifiedDate: {
        type: Date,
        default: Date.now
    },
   //     loginArray: [ String ]
        saltSecret: String
},
    {
    versionKey: false
});
// Duplicate the id field as mongoose returns _id field instead of id.
userSchema.virtual('userId').get(function () {
    return this._id.toHexString();
});

// Ensure virtual fields are serialised.
userSchema.set('toJSON', {
    virtuals: true
});


// Custom validation for emailId
userSchema.path('emailId').validate((val) => {
    let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return emailRegex.test(val);
}, 'Invalid e-mail.');

// Events
userSchema.pre('save', function (next) {
    bcrypt.genSalt(10, (err, salt) => {
        bcrypt.hash(this.password, salt, (err, hash) => {
            this.password = hash;
            this.saltSecret = salt;
            next();
        });
    });
});

// Methods
userSchema.methods.verifyPassword =  function (password) {
    console.log("password in db:  "+ this.password)
    console.log("password in login: "+ password)
    return bcrypt.compareSync(password, this.password);
};

//simply passing it the data we want to include in the token, plus a secret that the hashing algorithm will use.
userSchema.methods.generateJwt = function() {
    var expiry = new Date();
    expiry.setDate(expiry.getDate() + 7);
    return jwt.sign({ _id: this._id},
        "MY_SECRET",
        {
            expiresIn: parseInt(expiry.getTime() / 1000)
        });
};

// salt is a set of characters unique to a user
// salt combined with password makes a encrypted string which is stored in db
// so when a user logs in the same procedure is followed again
userSchema.methods.setPassword = function(password){
    this.salt = crypto.randomBytes(16).toString('hex');
    this.hash = crypto.pbkdf2Sync(password, this.salt, 1000, 64, 'sha512').toString('hex');
};

userSchema.methods.validPassword = function(password) {
    var hash = crypto.pbkdf2Sync(password, this.salt, 1000, 64, 'sha512').toString('hex');
    return this.hash === hash;
};

userSchema.methods.generateJwt = function() {
    var expiry = new Date();
    expiry.setDate(expiry.getDate() + 7);

    return jwt.sign({
        _id: this._id,
        emailId: this.emailId,
        exp: parseInt(expiry.getTime() / 1000),
    }, "MY_SECRET"); // DO NOT KEEP YOUR SECRET IN THE CODE!
};

module.exports = mongoose.model('user', userSchema);
