Feature: lab5
  The demo shows how to test of bdd in selenium
      
  Scenario Outline: Test login sukcessful to web service      
	Given there is a register page object
    When fields are filled <email>, <passwd>, <firstName>, <lastName>, <company>, <city>, <street>, <state>, <postalCode>, <country>, <phone>, <alias>, <registered> and form has posted
    Then form will be posting and account should be registered <registered>
    Examples:
      | email 							| passwd | firstName 	| lastName 	| company 	| city 		| street 	| state 	| postalCode 	| country 	| phone 		| alias | registered 	|      
	  | newSuperTestAccount@gmail.com	| passwd | jan			| kowalski	| Super x	| Bolszewo	| some		| Nevada	| 84239			| 48		| 512 596 321	| some	| false			|
	  | rand@wp.pl						| passwd | jan			| kowalski	| Super x	| Bolszewo	| some		| Nevada	| 84239			| 48		| 512 596 321	| some	| true			|
	

  Scenario Outline: Test login sukcessful to web service      
	Given there is a login page object
    When login <login> and password <pass> are filled
    Then form will be posting and account should be loged  <loged>
    Examples:
      | login 							| pass 		| loged |
      | newSuperTestAccount@gmail.com 	| passwd 	| true 	|
      | somenotExitsAccount@test.de		| somepass	| false |
      