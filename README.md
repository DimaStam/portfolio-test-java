# Sample Playwright Automation Portfolio

This repository contains demo E2E tests for two neutral stores (Store 1 and Store 2).
All data, URLs, and names are placeholders for portfolio use only.

## Tech stack
- Java
- Playwright
- TestNG
- Maven
- Faker
- Allure Framework

## Setup
1. Install JDK 24+.
2. Install Maven.
3. Clone the repository.

## Run tests

Command template (default suite):
`mvn clean test -Denvironment=demo -Dheadless=true`

Variables:
- `environment` - only `demo` is configured
- `headless` - true or false
- `test` - optional class or package pattern (disables default suite)
- `suiteXmlFile` - optional suite file (only when `-Dtest` is not used)

Examples:
- run all tests: `mvn clean test -Denvironment=demo -Dheadless=true`
- single class: `mvn clean test -Denvironment=demo -Dheadless=true -Dtest="ExampleTest"`
- package pattern: `mvn clean test -Denvironment=demo -Dheadless=true -Dtest="tests.pl.store1.*Test"`
- suite file: `mvn clean test -Denvironment=demo -Dheadless=true -DsuiteXmlFile="src/test/resources/suites/all-suites.xml"`

## Suites
TestNG suites live in `src/test/resources/suites`.
The main aggregator is `src/test/resources/suites/all-suites.xml`.
Default runs use `all-suites.xml` unless `-Dtest` is provided.

## Config
Config file: `src/test/resources/config.properties`

Keys:
- `demo.store1.url`
- `demo.store2.url`
- `demo.test.user.password`

## Allure
Generate a local report:
`mvn allure:serve`

## CI
A sample CI pipeline is provided in `.gitlab-ci.yml` for demo purposes.

## References
- Playwright: https://playwright.dev/java/docs/intro
- OpenJDK: https://openjdk.org/
- TestNG: https://testng.org/
- Maven: https://maven.apache.org/
- Faker: https://github.com/DiUS/java-faker?tab=readme-ov-file
- Allure Framework: https://allurereport.org/docs/
