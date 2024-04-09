## Prequisites:
* Appium server installed on the machine. In case not, install it by running command npm install -g appium. For more details visit: https://appium.io/docs/en/about-appium/getting-started/?lang=en

* iOS Simulator or Android Emulator or real device to execute tests.

* Install Maven in your machine. (Maven is a build tool) pom.xml file is present in base directory which has all the required dependencies.

## Installation
1. Install from git (using git clone)
2. Run "mvn clean test" from project directory


## Script Description
  apk Name: Google Maps (com.google.android.apps.maps)
  apk Location: Inbuilt (On Emulators/Simulator devices)
  feature file Location: /src/test/resources
  Type of Application: Native

## Running sample test
1. Connect your device to your machine or start the emulator
   Note: start appium server on your machine.
2. Run below commands to execute android testng test: mvn test
