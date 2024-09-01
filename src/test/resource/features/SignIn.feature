@all
Feature: SignIn Functionality

Background:
Given User has navigated to SignIn page

Scenario Outline: Login with valid credentials 
When User enters valid email address <email> into email feild
And User has entered valid password <password> into password feild
And User clicks on SignIn button
Then User should get successfully logged in
Examples:
|email                      |password        |
|kshitizgupta.edu@gmail.com |Kshitiz@1234    |


Scenario Outline: Login with invalid credentials
When User enters invalid email address <email> into email feild
And User enters invalid password <password> into password feild
And User clicks on SignIn button
Then User should get a proper warning message about credentails mismatch
Examples:
|email                        |password |
|er.kshitizgupta.edu@gmail.com|1234567  |


Scenario Outline: Login with valid email and invalid password
When User enters valid email address <email> into email feild
And User enters invalid password <password> into password feild
And User clicks on SignIn button
Then User should get a proper warning message about credentails mismatch
Examples:
|email                     |password |
|kshitizgupta.edu@gmail.com|1234567  |


Scenario Outline: Login with invalid email and valid password
When User enters invalid email address <email> into email feild
And User has entered valid password <password> into password feild
And User clicks on SignIn button
Then User should get a proper warning message about credentails mismatch
Examples:
|email                        |password|
|er.kshitizgupta.edu@gmail.com|Kshitiz@1234   |  


Scenario: Login without providing any credentials
When User dont enter email address into email feild
And User dont enter password into password feild
And User clicks on SignIn button
Then User should get a proper warning message about required feilds


 