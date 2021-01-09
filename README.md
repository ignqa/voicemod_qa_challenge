#5 Acceptance tests automated for the Voicemod website with Gradle and Selenide
Hey guys! How is it going on?
Today we are going make some testing for the Voicemod website.
The 5 acceptances test that we are going to provide some coverage are the next ones:
- The web is the one that we are expecting (ie, link is https and we have and expected result of that).
- The logo is the one that we are expecting on the top-left corner. Clicking on it we go back to the main webpage.
- We are able to select many languages and check if the website is correctly translated.
- We are able to download the software and trusting that binaries are the expected ones.
- We are able to contact the support team.

## What we are going to use for doing these automated validations?
- Gradle: Less complex syntax than Maven, cleaner for builds and executions, and better performance -> https://gradle.org/maven-vs-gradle/
- Selenide: Selenium upper-layer for having many web-drivers ("chrome", "firefox", "iexplorer", "safari" and phantome 
  ones) in a transparent one -> https://selenide.org/
- Allure: For representing the tests results, their performance, and having some graphical evidences of the failed ones
  -> https://docs.qameta.io/allure/

We are