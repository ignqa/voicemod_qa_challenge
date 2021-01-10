# Acceptance tests automated for the Voicemod website with Gradle and Selenide
Hey guys! How is it going on?
In this repository we are going to make some automated testing for the Voicemod website.
The five acceptances test that we are going to provide some coverage are the next ones:
- The web is the one that we are expecting (ie, link is https and we have and expected result of that).
- The logo is the one that we are expecting on the top-left corner.
- We are able to select many languages and check if the website is correctly translated (header title is the expected
  one for each language).
- We are able to download the software and trusting that binaries are the expected ones.
- We are able to contact the support team (in a blind day help from the outside is very welcome, even more when we 
  did not realize about our own problems, other ones could give us some light).

These five acceptance cases were taken into account according to the next criteria:
- **The company image is probably the most important thing we must preserve**. We must assure that people, when
  they want to access to our resources, they really do it, and they trust in them. Otherwise, we can blame ourselves
  that we are not protecting our own customers from being hacked at our expense, neither the brand future.
- To have quality in the offered resources means to mitigate the bad experience with them. However, sometimes 
  happen that our own users realize about the software problems before us. We must always keep the door open for the
  customer feedback. At the end, all of them together will spend so much time than the own testers doing (indirectly)
  the testing for the platform. They are the best testers, even when we do not want the bugs arrives to them.
- Voicemod 's users comes from every part of the globe. We need they can understand our main website in the most used
languages.
- We should assure that they are able to download our trusted-software! I guess that no explanation is needed
at this point :)

## What are we going to use for doing these automated validations?
- **Gradle**: Less complex syntax than Maven for configuring third-party sdk(s), cleaner for builds and executions, 
  and better performance -> https://gradle.org/maven-vs-gradle/
- **Selenium + Selenide**: Selenium upper-layer for having many web-drivers ("chrome", "firefox", "iexplorer", "safari" 
  and phantom ones) and syntax web elements higher-definition in a more transparent way -> https://selenide.org/
- **TestNG**: An evolved framework from JUnit -> https://testng.org/doc/  
- **Allure**: For representing the tests results, their performance, and having some graphical evidences of the failed 
  ones -> https://docs.qameta.io/allure/
- **Sonarqube**: For validating and adding value to the code, scanning it and giving feedback about how it can be 
  improved -> https://www.sonarqube.org/
  
## How this project is structured?

Easy. We will follow the Page Object Model pattern to structure our tests project:
- *src/main/java/helpers/Tools* contains the custom-needed utilities for the tests.
- *src/main/java/voicemod.websites/** contains (per class/website) the relevant web elements needed for the tests.
- *src/test/java/voicemod.websites/** contains the own automated tests.
- *src/test/resources/* contains all the needed resources employed in the tests assertions.

Do not confuse about the number of tests when you execute this suite. It they do not match with the number of acceptance
cases, it is because one, or many of them, could cover one acceptance case.

## Set-up & Go
Easy too. Just follow the next steps:
- Be sure that you have installed Firefox. Otherwise: https://www.mozilla.org/
- Install the most recent Java Oracle JDK: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Install gradle: https://gradle.org/install/
- Run:
  ```
  gradle test
  ```
  From the second time onwards use the --rerun-tasks parameter. We are telling gradle to build again this step, cause 
  if we do not do it, there were no changes in code, and last tests run succeeded, it will think that no tests' 
  execution is needed to make a build again.
  
**Extra**:

- **Allure:** If you want to give some sugar to the tests result, just launch the next build after executing the tests:
  ```
  $ gradle allureReport
  $ gradle allureServe
  ```
  Make a test fail! Then check the reports. You will be able even to see a snapshot of the browser and the code!
Execution tests timings, some graphs, more detailed and concised explanations about the fails... Awesome!
  
- **Sonarqube:** If you want to verify by your own the quality of the code, just follow the next steps:
    - Install docker: https://docs.docker.com/get-docker/
    - On a terminal:
    ```
    $ docker pull sonarqube
    $ docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
    ```
    - Go to your favourite browser: http://localhost:9000
    - User/pass: admin/admin. Set then your own password for the admin user.
    - Then set a new project name and generate a new token.
    - Use these values in the terminal now:
    ```
    $ gradle sonarqube \\
    -Dsonar.projectKey=<given_project_name> \\ 
  -Dsonar.host.url=http://localhost:9000 \\
  -Dsonar.login=<generate_token_value>
    ```
  Refresh the local website and then you will see the project reviewed by sonar.