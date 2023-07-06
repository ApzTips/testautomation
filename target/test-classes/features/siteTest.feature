Feature: Web Login

  @test
  Scenario Outline: User should able to jio login with valid phone number
    Given the user is on jio login page
    When jio login page
    And the user enters a jio valid phone number "<phoneNumber>"
    Then hits jio submit
    When OTP accepted select movie
    And Movie Played
    Then Close Browser
    Examples:
      | phoneNumber |
      | 7907446327  |
#      | 9539122174  |

