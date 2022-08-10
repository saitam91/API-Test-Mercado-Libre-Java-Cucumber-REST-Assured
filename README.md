
# Test Mercado Libre Java-Cucumber-REST-Assured

## Resume:
* This automated test framework was created based on BDD carrying out the best testing practices.
* To achieve this test framework, test cases with Mercado Libre API following this steps were created:

  **1. Carry out a search in Mercado Libre for 3 different items.**

  **2. Validate that the search results contain the word used as search criteria.**
 
-----------------------  

* In order to automate these test cases, the following classes and files were created:

  ***1. build.gradle file***  to define the build configurations that will be applied to all the modules in the project.

  ***2. Runner java class***  to execute scenario we want and how we want cucumber to run.
  
  ***3. Feature file***  in gherkin language where to declare in a parameterized way, the API endpoint and the criteria to perform the search.
  
  ***4. Step java class***  where the methods to be reproduced by the gherkin scenarios are implemented
  
------------------------
  
  ## Technologies used:

   - Language: JAVA

   - Building Tool: Gradle

   - Libraries: REST Assured-Cucumber 

* Enviroment Configuration:

  - Download and set JAVA environment variables (JAVA_HOME and PATH):JDK (17.0.2)

  - Download and installation IDE (IntelliJ IDEA)

* Cucumber Reports:

  - test-output/HtmlReport/ExtentHtml.html
  
  
 * Run Tests:

   - gradle clean
   
   - gradle test -D cucumber.options="--tags '@TestMELI'"




