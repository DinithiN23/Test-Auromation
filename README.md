# Test-Automation
![Selenium](https://img.shields.io/badge/Selenium-Java-blue) 
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-green)
![Status](https://img.shields.io/badge/Status-In%20Development-orange)

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Test Scenarios](#test-scenarios)
- [Directory Structure](#directory-structure)
- [How to Run Tests](#how-to-run-tests)

## Project Overview
This project automates the testing of the **Sauce Demo** website using **Selenium** and **Cucumber BDD**. The focus is on testing core functionalities such as login, adding items to the cart, and completing the checkout process.

URL https://www.saucedemo.com

Key Features:
- Implements the Page Object Model (POM) design pattern.
- Uses Cucumber for Behavior-Driven Development (BDD).
- Integrates hooks for efficient test setup and teardown.

---

## Technologies Used
- **Java**: Programming language.
- **Selenium WebDriver**: For browser automation.
- **Cucumber**: For BDD-style test cases.
- **JUnit**: For test execution.
- **Maven**: For dependency management.
- **PageFactory**: To simplify element handling.

---

## Setup and Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/sauce-demo-automation.git
   cd sauce-demo-automation

   Install dependencies using Maven:

bash
Copy code
mvn clean install
Ensure you have the following installed:

JDK 8 or higher 
ChromeDriver (compatible with your browser version)
IDE like IntelliJ IDEA or Eclipse
Test Scenarios

The project automates the following scenarios:

Login Functionality:
Valid Login with correct credentials.
Invalid Login with incorrect credentials.
Product Selection:
Adding products to the cart.
Removing products from the cart.
Checkout Process:
Filling out customer information.
Completing the order.

Directory Structure
src
├── main
│   ├── java
│   │   └── PoM               # Page Object Model classes
│   └── resources
├── test
│   ├── java
│   │   ├── steps            # Step Definitions
│   │   ├── utils            # Utility Classes (e.g., DriverManager)
│   │   └── TestRunner       # Test Runner Classes
│   └── resources
│       └── Features         # Cucumber Feature Files

How to Run Tests
Run All Tests: Execute the test suite using Maven:

bash

mvn test
Run Specific Feature File: Update the @CucumberOptions in your Test Runner to point to a specific feature file:

java

features = "src/test/resources/Features/SauceDemo.feature"
View Test Reports: After execution, view test results in the default report generated in target/cucumber-reports.
