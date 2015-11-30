Meta:

Narrative:
As a user
I want to have single choice poll
So that I can create polls, share it to my friends & collect the option about it

Scenario: Create a single choice poll successful
Given I have already login Zing Poll successfully with email <email> and password <password>
When I enter <question> into the question field
And I enter the <first_anwser> and <second_answer> into the answer fields
And I click the Create Poll button
Then The poll is created successfully


Examples:
|email |password |question|first_anwser|second_answer
|bddteam1@gmail.com|zingpoll|Have you ever applied BDD in your project?|Yes|No|

