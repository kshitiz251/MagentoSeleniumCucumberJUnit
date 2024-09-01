@all
Feature: Register functionality


Background:
Given User navigates to Create An Account page


Scenario: User creates an account with mandatory feilds
When User enters the details into below feilds
|firstName |Kshitiz                      |
|lastName  |Gupta                        |
|email     |kshitizgupta.edu@gmail.com   |
|password  |Kshitiz@1234                 |
And User clicks on Create An Account button
Then User account should get created successfully



Scenario Outline: User creates a duplicate account
When User enters the details into below feilds
|firstName |Kshitiz                     |
|lastName  |Gupta                       |
|email     |kshitizgupta.edu13@gmail.com|
|password  |Kshitiz@1234                |
And User enter duplicate email <email> in email feild
And User clicks on Create An Account button
Then User should get a proper warning about duplicate email
Examples:
|email                     |
|kshitizgupta.edu@gmail.com|


Scenario: User creates an account without filling any details
When User dont enter any details into feilds
And User clicks on Create An Account button
Then User should get a proper warning messages for every mandatory feild



 
