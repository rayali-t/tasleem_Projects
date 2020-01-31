'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

/**
 * Mongoose schema for expense object.
 */
let expenseSchema = new Schema({
    /**
     * user
     */
    userId: {
        type: String,
         required:'UserID cannot be empty'
    },
   /* user: {
        type: ObjectId,
        ref: "User"
    },*/
    /**
     * category of the expense.
     */
    /*category: {
        type: String,
        required: "category is required"
    },*/
    /**
     * expense amount
     */
    amount: {
        type: Number,
        required: "amount is required"
    },
    /**
     * expense description.
     */
    description: {
        type: String
    },

    /**
     * type
     */
    /*type: {
        type: String,
        default: "Expense"
    },*/
    /**
     * expense created date.
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
    }
}, {
    versionKey: false
});
// Duplicate the id field as mongoose returns _id field instead of id.
expenseSchema.virtual('expenseId').get(function () {
    return this._id.toHexString();
});

// Ensure virtual fields are serialised.
expenseSchema.set('toJSON', {
    virtuals: true
});

module.exports = mongoose.model('expense', expenseSchema);
