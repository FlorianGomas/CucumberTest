#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: A night in a bar
  Mr.Pignon and Mr.Leblanc wants to spend a night in a cocktail bar and order some drinks.
  
  Background:
  The bar only have 10 seats.
  You cannot enter the bar if there is not enough seats.
  Mr.Pignon have liver troubles, he is not happy if he drinks more than one drink.
  The months coktail cost 10$


  @Scenario1
  Scenario: The bar is full
    Given they are 9 people in the bar
    When Mr.Pignon and Mr.Leblanc arrive and try to get into the bar
    Then they cannot enter


  @Scenario2
  Scenario: The bar is not full and they order a drink
    Given they are 8 people in the bar
    When Mr.Pignon and Mr.Leblanc arrive and try to get into the bar
    And they both order a months cocktail
    And after the drinks are empty they check the bill
    And Mr.Leblanc pays for each
    Then the bar is full no more customer can enter
    And Mr.Pignon is happy

    @Scenario3
  	Scenario: The bar is not full and they order multiple drinks
    Given they are 3 people in the bar
    When Mr.Pignon and Mr.Leblanc arrive and try to get into the bar
    And they both order a months cocktail
    And after the drinks are empty they check the bill
    And each one pays his own drinks
    And Mr.Leblanc insist to order 2 more months cokctail on his bill
    And after the drinks are empty they check the bill
    And Mr.Leblanc pays for each
    Then Mr.Pignon is sad