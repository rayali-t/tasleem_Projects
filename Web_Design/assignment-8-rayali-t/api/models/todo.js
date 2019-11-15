'use strict';
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

/**
 * Mongoose schema for todo object.
 */
let TodoSchema = new Schema({
    /**
     * Title of the todo.
     */
    title: {
        type: String,
        required: "title is required"
    },
    /**
     * todo item created date.
     */
    createdDate: {
        type: Date,
        default: Date.now
    },
    /**
     * Todo content.
     */
    content: {
        type: String
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
TodoSchema.virtual('id').get(function(){
    return this._id.toHexString();
});

// Ensure virtual fields are serialised.
TodoSchema.set('toJSON', {
    virtuals: true
});

module.exports = mongoose.model('todo', TodoSchema);
