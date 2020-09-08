Feature: Dasa Challenge

  Scenario: Accessing the lab page through Dasa's site
    Given User opening the web browser
    When User access the URL "https://dasa.com.br/"
    Then Page should have a image with alt '"logo dasa"

    And Click on link "Nossas Marcas" on navbar
    Then Page should have a div with text "marcas da excelência"

    When Click on link with id "open-close" to search the labs
    And Click in combo field with id "region"
    And Select the option "São Paulo"
    Then the system should display all labs of São Paulo region.

    When Selecting the lab "Delboni Auriemo"
    Then Page should have the  "Delboni Auriemo" title
    And Page should have a link with a text "Delboni Auriemo"

    When Clicking on link with a text "Delboni Auriemo"
    Then User see the webpage of Delboni Auriemo lab.

    And close browser