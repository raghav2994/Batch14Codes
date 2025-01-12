Feature: Verify Whether EndToEnd testcase works

  Background: PreSteps to make sure user is on right state
    Given User is already loggedIn with credentials as "akhiljda@gmail.com" and "Password"


    Scenario: Add item to cart successfully
      Given User click on Item "Nike react infinity run flyknit"
      When User selects the item options size as "L" and color as "Green"
      And User clicks on AddToCart