# 23_Selenium_java_cucumber_bdd

## Commits

### first commit. create maven project
* [first commit. create maven project](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/8e8be6272b304f7b5853fb4f53f2a3a48b050984)
* [add image to readme.md](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/49c3ca312a8fcf7923de6fa3405e531d085f20e2)
* [add image to readme.md](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/94ead66cd2b46147ed94f15123c644f13f5c30f3)

### Created feature file for WebDriver University - Contact Us Page
* [created feature file for webdriver university contact cs page](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/d7c90adbd511d49fc9ae57ee048607c2a15f47b4)

### Added Junit 5 support
* [added junit 5 support](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/e30ef4f9107b8d1bf146b6394114ba7494ed4844)

### Created Step definition file WebDriver University - Contact Us Page
* [created step definition file for webdriver university contact cs page](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/9c8e4c3da9a4404bd03bbfa51dad8757a50277ff)

### Edge Browser Driver Setup
* [browser driver setup](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/5500fb5ec6febf4f07d435736857e7f1ba70721a)

### Implementing Step definition
* [implementing step definition](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/37d7b1959faa911b6d863fdbbe2ade68a2cf6ee5)

### Implementing Cucumber Expressions
* [implementing cucumber expressions](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/17ca4b5318785a6a2173bdf61122a769108d0d24)

### Runner class Tags and Reporting
* [runner class tags and reporting](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/b91f8895f67e3aeda34c0c28ea17c1d5455ae559)

### Use Case 2 - Login page
* [login page use case](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/e67c7356eb56911660e3d278276d836e077d8a31)

### Use Case 2 - Background keyword
* [background keyword](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/997bfd1664ce614776d65f475e0bc2d0b5c012d2)

### Use Case 2 - Expression and Parameter example
* [expression and parameter example](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/0c6245fafa95266e0bc77a4ff8a988cc7f90c373)

### Tags, Hooks and Driver Factory 
* [tags hooks and driver factory](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/fbbdb5cb0d38f5ebf5c2eddb47316cc9d61b53f5)

### Cucumber Parallel Execution
* [cucumber parallel execution](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/ce2b17b398d4c0bb5765dcacf3198016f0ed110e)

### Advanced Reporting Attaching Images to HTML
* [advanced reporting attaching images to html](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/5f6b0121e89fc5f2d36d9e4b9e7b8f8e5b0911c2)

### Base page custom commands
* [base page custom commands](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/92ec72e66504aa90f2e56e9cb5f2524672cd9d56)

### Page Object Models
* [page object models](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/b3bca64e7054c65f094ab801f1e47cc032fd350d)

### Constant Variables
* [constant variables](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/6c977a34b4a5ad395470dea713f4374c4f080ad4)

### Jenkins Configuration
* [jenkins configuration](https://github.com/bibhusprasad/23_Selenium_java_cucumber_bdd/commit/225e1d816d3807efdcbfbcc0c9c273ac06f5f1dc)

## Notes

### What is Gherkin?
Gherkin is a language that Cucumber understands. It is a business readable, domain specific language that lets you describe software's behaviour without detailing how that behaviour is implemented.

**Popular Keywords**
* **Feature file :** High level description of a software feature / test scenarios.
* **Scenario :** Used to describe specific test scenarios.
* **Given :** Describes the pre-requisite for given test scenarios.
* **When :** Describes an event or action.
* **And :** Provides a logical AND condition between statements.
* **Then :** Used to describe an expected outcome.

![plot](/images/feature_file.png?raw=true)

**Cucumber Expressions**
* [Cucumber Expressions Link](https://github.com/cucumber/cucumber-expressions)

![plot](/images/cucumber_expressions_parameter.png?raw=true)

**Cucumber Parallel Execution**
* [Parallel Execution Link](https://cucumber.io/docs/guides/parallel-execution/)
* [Parallel Execution For Junit5 Link](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine)

**Page Object Models**
* [Page Object Models](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

**Jenkins Integration**
* [Download Jenkins War file](https://www.jenkins.io/download/)
* [Supported java version](https://www.jenkins.io/doc/book/platform-information/support-policy-java/)

### Start Jenkins through command prompt

C:\dev>java -jar jenkins.war    (start in 8080 port)

C:\dev>java -jar jenkins.war --httpPort=9090    (start in custom port)

http://localhost:8080/login?from=%2F

provide administrator password

Install suggested package

Provide necessary details

### Configure Jenkins and Job creation and Job Configuration

Manage Jenkins -> tools -> Add JDK and Maven

Manage Jenkins -> plugin -> Install Maven Integration and Ansi color and cucumber reports

New Item -> give Item name -> select maven project -> ok

job/bdd-automation-framework/configure 
    
root pom -> D:\intellij_projects\selenium-java-cucumber-bdd\pom.xml

goals and options -> clean compile test -Dcucumber.filter.tags="@regression"

build environment -> color ANSI consol output -> xterm

post build action -> cucumber reports -> advanced -> json report path -> D:\intellij_projects\selenium-java-cucumber-bdd\target\cucumber-report

save

click on build now


### Target Specific tag in Jenkins

goals and options -> clean compile test -Dcucumber.filter.tags="@${tag}"

select this project is parameterised -> Add parameter -> choice parameter -> then put name as tag and choice as regression and contact-us and login

### Target Specific thread count

goals and options -> clean compile test -Dcucumber.filter.tags="@${tag}" -Ddataproviderthreadcount=${threadCount}

select this project is parameterised -> Add parameter -> choice parameter -> then put name as threadCount and choice as 5 4 3 2 1
