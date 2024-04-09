Feature: argos test

  Scenario: negatvie test with invaild username
	Given Open Argos app
	And Click menu
	And Click on Signin or login
	And click signin
	And enter the username "at.vikram3"
	And invalid username error message is displayed

  Scenario: negatvie test with invaild password
	Given Open Argos app
	And Click menu
	And Click on Signin or login
	And click signin
	And enter the password "asdfghjkl"
	And invalid password error message is displayed

  Scenario: positive test for argos

	Given Open Argos app
	And Click menu
	And Click on Signin or login
	And click signin
	And enter the username "at.vikram30@gmail.com"
	And enter the password "9940683081Va"
	And click on signin button

