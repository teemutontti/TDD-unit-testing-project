# TDD-unit-testing-project

## Running the App

At the root of the project type `javac -d bin src/main/*.java`
and then `java -cp bin main/App`.

## Running the Tests

At the root of the project type `javac -d bin -cp lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar src/main/*.java src/test/*.java`
and then `java -cp "bin;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" test.TestSuiteRunner`

Combined: `javac -d bin -cp lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar src/main/*.java src/test/*.java && java -cp "bin;lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar" test.TestSuiteRunner`
