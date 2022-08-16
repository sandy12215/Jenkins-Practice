@functionalscenario
Feature: verify the search functionality of Google
@second
Scenario Outline: user wants to verify the functionality for positive data
Given user open the browser
When user enters the URL "https://www.google.com/"
Then user enters the '<search>' data
And user press enter key
Then user wants to verify whether search result is displayed in the next page
And close the browser
Examples: 
|search|
|selenium|
|java|