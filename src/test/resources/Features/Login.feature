Feature: login

  Scenario: successful login with valid credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And The user has to fill email "admin@yourstore.com" and password "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on log out Link
    Then Page Title should be "Your store. Login"
    And Close browser