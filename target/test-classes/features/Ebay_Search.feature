@tag1
Feature: Verify Ebay Item Search

  # Background: Verify Sign In
  #  Given Click on sign in hyperlink
  # When Enter username
  #And Click on continue button
  #When Enter password
  #And Click on sign in button*/
  Scenario: Verify Item Search
    Given Enter item name in search box
    When Click search button
		And Select "1" number item in the list
    Then Check item available or not
