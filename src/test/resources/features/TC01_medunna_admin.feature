@medunna_admin
Feature: Medunna Admin

  Background: Sign In As Admin
    Given user navigates to "https://medunna.com"
    When click on user icon
    And click on sign in link
    And enter username
    And enter password
    And click on sign in submit button

  @createRoom  @e2e
  Scenario Outline: Create Room
    When click on itemsAndTitles link
    And click on room link
    And click on create a new room link
    And enter room number "<room number>"
    And select room type "<room type>"
    And click on status checkbox
    And enter price "<price>"
    And enter description "<description>"
    And click on save button
    Then assert the alert message contains A new Room is created
    And close the application
    Examples:
      | room number | room type      | price | description                                           |
      | 881133133   | DAYCARE        | 333   | This room was created for cucumber practice e2e test |
#      | 881223733   | PREMIUM_DELUXE | 678   | This room was created for cucumber practice Example 2 |
#      | 881773833   | DELUXE         | 908   | This room was created for cucumber practice Example 3 |
#      | 881003633   | SUITE          | 500   | This room was created for cucumber practice Example 4 |

  @MedunnaMessage
  Scenario Outline: Send Message
    When click on itemsAndTitles link
    And click on messages link
    And click on create a new message link
    And enter name "<name>"
    And enter email "<email>"
    And enter subject "<subject>"
    And enter message "<message>"
    And click on save submit button
    Then assert the alert message contains A new Message is created
    And close the application
    Examples:
      | name  | email         | subject | message                     |
      | John  | john@doe.com  | Hi      | This is an urgent situation |
      | Mary  | mary@doe.com  | Hello   | This is my message          |
      | Harry | harry@doe.com | Ola!!   | This is Spanish message     |
      | Ali   | Ali@doe.com   | Merhaba | This is Turkish message     |