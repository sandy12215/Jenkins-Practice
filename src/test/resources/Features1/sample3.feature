Feature: verify the functionality of Google application
Background: 
Given user open the browser 
When user enters the URL "https://www.google.com/"
Scenario: the user wants to verify the functionality of the URL.
Then user wants to verify whether the page is loaded or not
And close the browser
Scenario Outline: user wants to verify the functionality for positive data
Then user enters the '<search>' data
And user press enter key
Then user wants to verify whether search result is displayed in the next page
And close the browser
Examples: 
|search|
|selenium|
|java|