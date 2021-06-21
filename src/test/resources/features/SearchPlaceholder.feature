  #Author: Ilona Shabelnyk
  #Team: EPAM TA Basic_Kyiv_2021 Q2 [DEP]

  Feature: As a customer I want to provide a meaningful placeholder for search input field so that users can use search feature more efficiently

    @test
    Scenario: Validation of search input field placeholder
      Given Bookdepository website is opened on the main page
      When search input field is found
      Then there is placeholder "Search for books by keyword / title / author / ISBN"