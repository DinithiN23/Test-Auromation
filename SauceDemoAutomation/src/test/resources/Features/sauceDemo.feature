Feature: Saucedemo Checkout Functionality Happy Path

  Background: 
    Given I am on the Saucedemo login page
    When I login with username "standard_user" and password "secret_sauce"

  @assignment
  Scenario: Complete Checkout Process
    Given I am on the Products page
    When I add following items to cart    
    And I click the cart button
    Then I should be on the cart page
    Then I should see the selected items in cart
    When I click the Checkout button
    Then I should be on the checkout:your information page
    And I enter customer information
      | FirstName | LastName | ZipCode |
      | Hiruni    | Perera   | 012525  |
    And I click continue
    Then I should be on Checkout :overview page
    And I click finish button
    Then I should be on Checkout: complete page
    And I click back home button
    Then I should be on Product page again
    
    
    
   
    
    
    
    
     
   