  #Author: Ilona Shabelnyk
  #Team: EPAM TA Basic_Kyiv_2021 Q2 [DEP]

  Feature: As a user I want to get ability to use "Sign in/Join" button so that I can get Login page

    @test
    Scenario: When clicking on "Sign in/Join" button, user is redirected into Login page
      Given Bookdepository website is opened on the main page
      When SigninJoin button is clicked
      Then Login page is opened