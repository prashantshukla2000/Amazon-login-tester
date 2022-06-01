Feature: Test the login functionality on amazon

Scenario: The user should be able to login with correct username and password
Given user is on the login page
When user enters correct email and password
Then user gets confirmation  

Scenario: The user should be able to signup 
Given user is on the login page
When user is on the signup page
And user enters details
Then user gets approval  