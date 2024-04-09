Feature: chrome Proof Of Concept

  Scenario: chrome search for Itprobit
    Given Open Google Chrome
    #Then Search for Itprobit
    #Then Click on Itprobit
    And Click back to restaurant open
    And Click on dine in
    And Sees dine in restaurant only
    And Click on dine in
    Then Open only opened restaurants nearby



  #Scenario: GMaps get distance to Marina beach
   # Given Search for Marina Beach
   # And Get Directions
    #Then Get the Distance