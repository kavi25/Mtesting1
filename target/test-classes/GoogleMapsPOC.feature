Feature: Google Maps Proof Of Concept

  Scenario: GMaps search for restaurants nearby
    Given Open Google Maps
    Then Search for Nearby Restaurants
    Then Open only opened restaurants nearby
    And Click back to restaurant open
    And Click on dine in
    And Sees dine in restaurant only
    And Click on dine in
    Then Open only opened restaurants nearby



  Scenario: GMaps get distance to Marina beach
    Given Search for Marina Beach
    And Get Directions
    #Then Get the Distance