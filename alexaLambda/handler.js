'use strict';
var request = require('request');
var async = require('async');
var Alexa = require('alexa-sdk');
var APP_ID = undefined;  // TODO replace with your app ID (OPTIONAL).


// Credentials
var u = 'test@liferay.com',
    p = 'test',
    baseAuthUrl = 'http://' + u + ':' + p + '@52.24.188.235:8080',
    baseUrl = 'http://52.24.188.235:8080';


// Main
module.exports.alexa   = function(event, context, callback) {
    console.log('Hi');
    var alexa = Alexa.handler(event, context);
    alexa.APP_ID = APP_ID;
    alexa.registerHandlers(handlers);
    alexa.execute();
};


// Handlers
var handlers = {
    'LaunchRequest': function () {
        this.emit('SayHello');
    },
    'SayHello': function () {
        this.emit(':tell', 'Liferay at your service!');

    },

    'GenerateCertificatesIntent': function () {
        var alx = this;
        async.series([
            function(callback) {
              generatePdf(callback);
            },
            function(callback) {
              alx.emit('GeneratingPDF');
              callback(null, 'alexa');
            }
        ]);
    },
    'GeneratingPDF': function () {
        this.emit(':tell', 'Generating PDF');
    },

    'UsersCountIntent': function () {
        var alx = this;
        async.series({
            users: function(callback) {
              usersCount(callback);
            }
        // optional callback
        }, function(err, results) {
            alx.emit(':tell', 'There are ' + results.users + ' users');
        });
    }
};


// Generate PDF
var generatePdf = function(callback) {
     var options = {
      url: baseUrl + '/o/api/pdf/generate',
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
        callback(null, 'request');
      }       
    });  
}


// Users count
var usersCount = function(callback) {
     var options = {
      url: baseAuthUrl + '/api/jsonws/hack.userscreated/get-users-count',
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
        callback(null, info);
      }       
    });  
}

