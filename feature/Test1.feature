Feature: Automated test of values page
Description: verifies and asserts that values are correct

Scenario: Verify Values
	Given user is on Home Page
	Then verify the value count is 5
	And values are greater than zero
	And values are in currency format
	And total balance is correct
