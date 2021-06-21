  #Author: Ilona Shabelnyk
  #Team: EPAM TA Basic_Kyiv_2021 Q2 [DEP]

  Feature: As a user I want to get ability to open Bookdepository website

    @test
    Scenario: When opening Bookdepository website in the browser, user is redirected into proper Home page
      Given Bookdepository website is opened on the main page
      Then user is redirected into proper Home page