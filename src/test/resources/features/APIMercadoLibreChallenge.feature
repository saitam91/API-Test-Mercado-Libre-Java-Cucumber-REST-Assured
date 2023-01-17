@MeliChallenge
Feature: As a test engineer I want to test a real API

  Scenario Outline: API Test on Mercado Libre
    Given I send get request to https://api.mercadolibre.com URI
    When I search for <Criteria> in the endpoint /sites/MLA/search?q=
    Then I can validate the number of products found for <Criteria> and that it does not exceed the page limit

    Examples:
      |Criteria        |
      |Nintendo        |



