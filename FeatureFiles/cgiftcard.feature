Feature: gift card

  Scenario: customize gift card
    Given user on homePage and  user click o gift card
    When scroll down to the birthday/anniversary click on that
    And fill customize your gift card amount as "1300" and select month and date click on next
    And fill the all recipient details and to deatils with wrong email id click on confirm capture the error messsage
      | Recipientname   | hari            |
      | Recipientemail  | hari#12         |
      | Recipientnumber |      9123456789 |
      | YourName        | likhi           |
      | YourEmail       | likhi@98        |
      | YourNumber      |      9876543217 |
      | YourAddress     | #234            |
      | YourPin         |          600001 |
      | YourMessage     | hi lucky person |
    And enter valid email id and clickON confirm
      | ValidREmail | Hari@123 |
    Then validate the all the from and to details
      | Recipientname   | hari            |
      | Recipientemail  | Hari@123        |
      | Recipientnumber |      9123456789 |
      | YourName        | likhi           |
      | YourEmail       | likhi@98        |
      | YourNumber      |      9876543217 |
      | YourAddress     | #234            |
      | YourPin         |          600001 |
      | YourMessage     | hi lucky person |
