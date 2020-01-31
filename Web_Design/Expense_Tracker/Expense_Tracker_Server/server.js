const postsRoutes = require("./api/routes/expense-route");
const userRoutes = require("./api/routes/user-route");


let express = require('express'),
    app = express(),
    port = process.env.PORT || 3000,
    mongoose = require('mongoose'), //created model loading here
    bodyParser = require('body-parser');
   // require('./config/passportConfig');
    let passport = require('passport');

app.use(passport.initialize());

// mongoose instance connection url connection
mongoose.connect('mongodb://localhost:27017/expenseTracker', {
   // useMongoClient: true,
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: false
});
mongoose.Promise = global.Promise;

//Added function that confirms database connection establishment on the console
let db = mongoose.connection;
db.once('open',function(){
    console.log("Connected to MongoDB Database");
});

//Adding body parser for handling request and response objects.
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());

//Enabling CORS
app.use(function (req, res, next) {
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader(
      "Access-Control-Allow-Headers",
      "Origin, X-Requested-With, Content-Type, Accept, Authorization"
    );
    res.setHeader(
      "Access-Control-Allow-Methods",
      "GET, POST, PATCH, PUT, DELETE, OPTIONS"
    );
    next();
});

//Initialize app
let initApp = require('./api/app');
initApp(app);

app.listen(port);
console.log('Expense Tracker RESTful API server started on: ' + port);


//Node mail
const nodemailer = require('nodemailer');

let transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: 'webdesignf2k19@gmail.com',
        pass: 'Webdesign@2019'
    }
});

let mailOptions = {
    from:'webdesignf2k19@gmail.com',
    to: 'mounicadantuluri@gmail.com', 
    subject: 'Login Successfully',
    text: "login successfully"
};

transporter.sendMail(mailOptions, function(err, data) {
    if(err){
        console.log('Error occurs');
    } else {
        console.log("The message has been sent!");
    }
});


app.use("/api/posts", postsRoutes);
app.use("/api/user", userRoutes);

module.exports = app;