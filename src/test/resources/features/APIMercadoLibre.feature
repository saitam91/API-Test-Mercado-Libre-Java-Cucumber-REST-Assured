@TestMELI
Feature: As a test engineer I want to test a real API


  Scenario Outline: API Test on Mercado Libre
    Given I send a get request to https://api.mercadolibre.com URI
    Then I validate that the result search matches with the search criteria <Criteria> in the endpoint /sites/MLA/search?q=

    Examples:
      |Criteria        |
      |Xbox            |
      |Polystation     |
      |Nintendo        |




