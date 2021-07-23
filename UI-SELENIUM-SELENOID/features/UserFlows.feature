Feature: User flows

  Scenario: Test Sign In feature - happy path
    Given I launch the browser
    When I open login page and enter correct credentials
    Then The user is signed in and user name is displayed in the title sector
    And Close the browser

  Scenario: Test if I can add product to cart
    Given I launch the browser
    When I navigate to summer dresses catalog and add first item to the cart
    And I can see proceed to checkout popup and I tap on proceed to checkout button
    Then The item with specific SKU is added to cart
    And Close the browser

  Scenario: Test if I can work with tables in Shopping Cart
    Given I launch the browser
    When I add a few items into the cart and open it
    And Increase second item quantity to 2
    Then The total prise of the item is doubled
    And Close the browser