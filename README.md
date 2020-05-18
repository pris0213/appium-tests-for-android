# Appium Tests for Android

The reason I'm developing this project is because I want to learn how to test mobile apps with Appium. 

Here you'll find a very simple set of tests for the native Calculator app on Android.
These tests are developed in Java, using Appium and TestNG.

## Requirements

### Java

To run this project, you need to have [Java](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) installed to your machine.
Make sure you have all Java environment variables set in your computer.

### Android Studio 

Appium requires [Android SDK](https://developer.android.com/studio/?gclid=EAIaIQobChMI45X81NC96QIVhwuRCh1wWQS_EAAYASAAEgKX4fD_BwE&gclsrc=aw.ds#downloads). 
You'll also need Android Virtual Device (AVD) in case you choose to use an Android emulator for testing instead of a real device.

If you don't want to download Android Studio IDE, you can [download Android SDK and AVD only](https://medium.com/michael-wallace/how-to-install-android-sdk-and-setup-avd-emulator-without-android-studio-aeb55c014264).

Make sure to [set the necessary Android variables]((https://stackoverflow.com/questions/19986214/setting-android-home-enviromental-variable-on-mac-os-x)) in your machine.
You may also need to [configure ANDROID_HOME on Appium](https://discuss.appium.io/t/original-error-could-not-find-adb-please-set-the-android-home-environment-variable/21528/23). 


### Appium

You can either install Appium from the command line:

```
$ npm install -g appium
```

In this case, you'll need [Node.js and NPM](https://nodejs.org/en/).

Or you can simply download the [desktop version](https://github.com/appium/appium-desktop).

## Running tests

Type the following command on your terminal:

```
$ mvn test
```

## About Appium

* "Appium is an open-source tool for automating native, mobile web, and hybrid applications on iOS mobile, Android mobile, and Windows desktop platforms."
* Appium uses Selenium WebDriver, the standard tool for web automation.
* Appium has a client/server structure that allows tests to be written in "any language that has a HTTP client API".
    * Languages supported include Java, Python, Ruby, JS, C# and PHP. 
  
## Sources

* [Introduction to Appium — Appium](http://appium.io/docs/en/about-appium/intro/?lang=en)
* [Appium Native Java Tutorial — Applitools](https://applitools.com/tutorials/appium-native-java.html#install-the-sdk)
* [Java Sample Code — GitHub](https://github.com/appium/appium/tree/master/sample-code/java)
* [AWS Device Farm Appium Cucumber Tests For Sample App — GitHub](https://github.com/aws-samples/aws-device-farm-appium-cucumber-tests-for-sample-app)
* [APPIUM Tutorial for Android & iOS Mobile Apps Testing — Guru99](https://www.guru99.com/introduction-to-appium.html)
* [Chapter-13: Appium Tips and Tricks — Kobiton](https://kobiton.com/book/chapter-13-appium-tips-and-tricks/)
* [35 Tips You Should Know About Appium Testing — BitBar](https://bitbar.com/blog/things-you-should-know-about-appium/)
* [TestNG Tutorial  – Complete Guide For Testers — Software Testing Material](https://www.softwaretestingmaterial.com/testng-tutorial/)
