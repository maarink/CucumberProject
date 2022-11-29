Feature: Customers

 Background: Below are the commen steps for each scenario 
 Given User Launch Chrome browser
 When User opens URL "http://admin-demo.nopcommerce.com/login"
 And The user has to fill email "admin@yourstore.com" and password "admin"
 And Click on Login
 Then User can view Dashboad

Scenario: Add a new Customer
 
 When User click on customers Menu
 And Click on customers Menu Item
 And Click on Add new button
 Then User can view Add new customer page
 When User enter customer info
 And Click on Save button
 Then User can view confirmation message "The new customer has been added successfully."
 And Close browser

 
 Scenario: Search customer By EmailId
 When User click on customers Menu
 And Click on customers Menu Item
 And Enter customer MailId
 When Click on Search button
 Then User should found Email in the search table 
 And Close browser
 
 Scenario: Search customer By name
 When User click on customers Menu
 And Click on customers Menu Item
 And Enter customer Firstname
 And Enter customer Lasttname
 When Click on Search button
 Then User should found name in the search table 
 And Close browser