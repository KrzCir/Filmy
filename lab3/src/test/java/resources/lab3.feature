Feature: lab3
  The demo shows how to test of film service

  Scenario Outline: Test using remove function
    Given there is a film service object
    When <expression> are removed
    Then the result after remove should be <result>
    Examples:
      | expression 	| result |
      | 1			| 4 |
      |	dir 2 		| 4 |
      | prod 3		| 4 |
      | title 4    	| 4 |
 
   Scenario Outline: Test using Find by Expression
    Given id <id> to prepare data
    When <expression> are searched
    Then the result title using expression should be <result>
    Examples:
      | id | expression | result 	|
      | 1  | 1			| title 1 	|
      |	2  | dir 2 		| title 2 	|
      | 3  | prod 3		| title 3	|
      | 5  | title 5    | title 5   |
      | 99 | Horror		| title 99	|