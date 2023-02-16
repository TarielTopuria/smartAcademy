# Test Automation Project for https://officemart.ge web page.
This is a test automation project where IntelliJ IDEA, Java 11, Maven, Selenide, TestNG, and Allure is used. 

The purpose of this project is to automate testing for the https://officemart.ge web page.

## Getting Started
To get started with this project, you will need to have the following tools installed on your system:

* Java 11 or higher;
* Maven;
* Any Integrated Development Environment (IDE);
* Chrome and Chromedriver (UI tests use Chrome by default, but can be changed).

You can clone the repository from GitHub using the following command:

`git clone https://github.com/TarielTopuria/smartAcademy.git`

Once you have cloned the repository, you can import the project into your IDEA and start working with it.

## Running Tests
There are several ways to run the tests:

1. Using tesng.xml file.
- Go to project folder and find testng.xml file; 
- Select the testng.xml file, right-click on it, and select Run; 
- The IDE will execute XML file as TestNG suite.

2. Using terminal:
- Open the project;
- Open the terminal;
- use the following command in the terminal: `mvn test`;
- This will run all the tests in the project. 

You can also run a specific test class or test method by specifying the class or method name in the command.

## Generating Reports
This project uses Allure to generate reports for the tests. To generate the reports, you can use the following command:

`mvn allure serve`

This will generate the reports and open them in your default browser. You can also generate the reports in a specific directory using the following command:

`mvn allure report`

This will generate the reports in the "target/site/allure-maven-plugin" directory.

## Conclusion
This test automation project is a great way to get started with test automation using Java, Selenide, TestNG, and Allure. With this tools and frameworks, it is easy write automated tests for web application like https://officemart.ge, and generate reports to track the progress.
