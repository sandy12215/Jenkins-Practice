@functionalscenario
Feature: to verify the functionality of the application.
@first
Scenario: the user wants to verify the functionality of the URL.
Given user open the browser 
When user enters the URL "https://www.google.com/"
Then user wants to verify whether the page is loaded or not
And close the browser