'use strict';
var request = require('request');
var Alexa = require('alexa-sdk');
var APP_ID = undefined;  // TODO replace with your app ID (OPTIONAL).

module.exports.pdf   = function(event, context, callback) {
    console.log('Hi');
    var alexa = Alexa.handler(event, context);
    alexa.APP_ID = APP_ID;
    alexa.registerHandlers(handlers);
    alexa.execute();
};

module.exports.liferay   = function(event, context, callback) {

    let result = "teste";

    success(result, callback);
};

// Return a success callback
var success = function(event, cb) {


    var responseCode = 200;

    var response = {
        statusCode: responseCode,
        headers: {
            "Access-Control-Allow-Origin": "*"
        },
        body: JSON.stringify(event)
    };

    return cb(null, response);
}

var handlers = {
    'LaunchRequest': function () {
        this.emit('SayHello');
    },
    'PDFIntent': function () {
         var options = {
          url: 'http://64c53649.ngrok.io/o/api/pdf/generate',
          headers: {
            'User-Agent': 'request'
          }
        };


        request(options, function(error, response, body){
          if (error)
            console.log(error)
          else {
            var info = JSON.parse(body);
            console.log(info);
            this.emit('PDFGenerated');
          }       
        });

    },
    'PDFGenerated': function () {
        this.emit(':tell', 'PDF Generated');
    }
};