# Demo
This is a demo cucumber/selenium automation project for a simple web page test automation.
The coding is done in Java.

Requirements:  Java (jdk 8 or higher), Cucumber, Selenium, Junit, Chrome browser

Structure: The "feature" folder contains the feature file. The "pageObjects" folder has the java class file for POM of this web page. The "stepDefinitions" folder has the java file for all steps defined in Test Scenario. The "util" folder has common utils file.

Config: There isn't much configuration required except to change the location of Chrome driver in Steps.java file.

Running: Junit runner is used to launch the TestRunner java class (with cucumber options) as shown below:

         >> java org.junit.runner.JUnitCore TestRunner
         
         Or you can run it from Eclipse

The Results.png is a mock file of how the results would appear when run using junit Test Runner.
