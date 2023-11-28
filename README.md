# TDD-unit-testing-project

## Description

This is a Java CLI application that manages user's budgets.
You can add new budgets with a specific saving goal and add transactions to those budgets. The application then shows the sum of income and expenses.
This project is mainly focused on using TDD and unit-testing practices.
Data is saved in data-folder as CSV-files.

## Running the App

At the root of the project type run the app with: `javac -d bin src/main/*.java && java -cp bin main/App`.

## Running the Tests

At the root of the project run the tests with: `javac -cp ".;bin;lib/junit-4.12.jar" -d bin src/main/*.java src/test/*.java && java -cp "bin;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" test.TestSuiteRunner`
