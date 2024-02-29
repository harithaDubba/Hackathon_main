Feature: project

  Scenario: BookShelves Kids
    Given the user navigate to the urban ladder page and search as "BookShelves"
    When the user should be redirected to the Bookshelves page close the popup
    And select category as "Kids Bookshelves" select price as below fifteen thousand exclude out of stock  sort By  hight to low
    Then the user should get the first three bookshelves name and price
