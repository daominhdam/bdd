Meta:

Narrative:
As a user
I want to login to Zingpoll website
So that I can use all features


Scenario: Login ZingPoll system fail
Given I am on ZingPoll website
When I change English language for website
Then I click the Sign In button on the menu bar to register an new account
Then The Sign In form should be shown
When I enter email <email> and password <password>
And I click the Sign In button on the form
Then I verify the failure message <message>

Examples:
|email |password |message|
|||The email is required and cannot be empty|
|testmyfailure@gmail.com||The Password is required and cannot be empty|
|bddteam1@gmail.com|123456|Login failed! Incorrect password.|

Scenario: Login ZingPoll system successful
Given I am on ZingPoll website
When I change English language for website
Then I click the Sign In button on the menu bar to register an new account
Then The Sign In form should be shown
When I enter email <email> and password <password>
And I click the Sign In button on the form
Then I log in into website successful


Examples:
|email |password |
|bddteam1@gmail.com|zingpoll