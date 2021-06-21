  #Author: Ilona Shabelnyk
  #Team: EPAM TA Basic_Kyiv_2021 Q2 [DEP]

  Feature: As a user I want to get ability to perform search so that I can find required book and buy it

    @test
    Scenario: Validation that the search is performed / search results are not empty (more than 0)
      Given Bookdepository website is opened on the main page
      When search term is entered into search input field
      And Search button is clicked
      Then search is performed and search results are not empty