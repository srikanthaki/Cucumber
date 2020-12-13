@Search
Feature: Search Functionality in Amazon website

  @Sanity
  Scenario Outline: Provide the search function to the user to have quick acces to the required product
    Given The user is already on the Amazon Home Page
    When User click on search bar and type "<ProductName>"
    Then User should be shown all the available "<ProductName>" in the inventory
    But User should not see the "<ExcludedProduct>"

    Examples: 
      | ProductName | ExcludedProduct |
      | Laptop      | Dell            |
      | Mobiles     | Samsung         |

  @Smoke @Regression
  Scenario Outline: Provide the search function to the user to have quick acces to the required product
    Given The user is already on the Amazon Home Page
    When User click on search bar and type "<ProductName>"
    Then User should be shown all the available "<ProductName>" in the inventory
    But User should not see the "<ExcludedProduct>"

    Examples: 
      | ProductName | ExcludedProduct |
      | Laptop      | Dell            |
      | Desktop     | Samsung         |
