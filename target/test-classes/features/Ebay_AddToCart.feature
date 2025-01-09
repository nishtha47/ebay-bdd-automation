@Credentialing
Feature: Verify Add To Cart Option
 
  Background: Verify Item Search
   Given Enter item name in search box
    When Click search button
		And Select "1" number item in the list
    Then Check item available or not

  Scenario: Verify add to cart option
    Given Click add to cart button
  	Then Verity the item price












