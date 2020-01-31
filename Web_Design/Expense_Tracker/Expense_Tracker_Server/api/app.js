'use strict';
module.exports = function (app) {
    //Initialize models
    let expenseModel = require('./models/expense');
    let userModel = require('./models/user');
    require('./config/passportConfig');
    //let passport = require('passport');


    //Initialize routes
    let expenseRoutes = require('./routes/expense-route');
    expenseRoutes(app);
    let userRoutes = require('./routes/user-route');
    userRoutes(app);
};
