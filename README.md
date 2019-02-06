# LearningAutomation

## Goals for this test automation project

* Learn Java and selenium, utilising Alan Richardson's course (see Credits)
* Incorporate tools / frameworks in order to practice what I am learning on current projects. These include:
    -   &#9989; JUnit tests (initially but switching) to Gherkin - not started.
    -   &#9989; Cucumber archetype descriptor (specifying src/test) required (for switching from JUnit to Gherkin)
    -   &#9989; Maven (initially but switching) to Gradle
    -   Gherkin
    -   &#9989; Logging
    -   Page Object model
    -   Page Factory
    -   Jenkinsfile (for multibranch pipelines)
    -   YAML file for test data
    -   WebDriver Factory

## Running the tests

* Download project - git clone https://github.com/KarinReid/learningAutomation.git
* Execute via command line :
    JUnit tests -> gradle test --tests *NameOfTest


## Framework

In order to support the above goals, this Framework will change accordingly.
* [Maven](https://maven.apache.org/) - Dependency Management & Build tool.
* [Gradle](https://gradle.org/install/) - Dependency Manager & Build tool.
* [Java](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) - JDK & JRE.
* Log4j2 - logger

## Version Control

GIT, GitHub code repository - https://github.com/KarinReid/learningAutomation

## Contributor

Karin Reid,
karin.reid@assurity.co.nz,
Mobile - +64 210 2994694,
LinkedIn - https://www.linkedin.com/in/karinreid/

## Credits
* [Alan Richardson's Selenium Webdriver with Java course](https://compendiumdev.zenler.com/courses/selenium-2-webdriver-basics-with-java)

## Future considerations
* Depending on the goal of the framework, use an archetype descriptor to support page objects, unit tests, etc.