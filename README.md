# Mobile App Testing with Appium for Cross-Platform Compatibility

## Project Overview

This project demonstrates how to perform both **manual and automated tests** for a mobile app using **Appium**, ensuring **cross-platform compatibility** for Android and iOS devices. The goal is to verify the app's functionality, usability, and performance across different platforms.

---

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Project Setup](#project-setup)
3. [Manual Testing](#manual-testing)
4. [Automated Testing with Appium](#automated-testing-with-appium)
5. [Test Execution](#test-execution)
6. [Reporting](#reporting)
7. [Contributing](#contributing)
8. [License](#license)

---

## Prerequisites

Before you begin, ensure you have the following tools installed:

- **Java (JDK 8 or above)**
- **Android Studio** (for Android testing)
- **Xcode** (for iOS testing)
- **Appium** (for automating the tests)
- **Appium Desktop** (for visualizing test execution)
- **TestNG** (for running the test cases)
- **Maven/Gradle** (for dependency management)
- **Android Emulator/iOS Simulator** or physical devices

You can install the required dependencies via Maven/Gradle as mentioned in the `pom.xml` or `build.gradle` files.

---

## Project Setup

### 1. Clone the Repository

```bash
git clone https://github.com/CodeSavvy77/mobile-app-testing-appium.git
cd mobile-app-testing-appium
```

### 2. Install Dependencies

Run the following Maven command to install the required dependencies:

```bash
mvn clean install
```

Or if you are using Gradle, run:

```bash
gradle build
```

### 3. Appium Server Setup

- Install **Appium** globally via npm:

```bash
npm install -g appium
```

- Launch **Appium Server**:

```bash
appium
```

---

## Manual Testing

### Steps for Manual Testing:

1. **Test Case Documentation:** Create detailed test cases for various functionalities (e.g., login, search, checkout) in the app.
2. **Platform Specific Checks:**
    - For **Android**, check for UI consistency, button functionality, and app navigation.
    - For **iOS**, validate UI elements, gestures, and app-specific behaviors.
3. **Cross-Platform Testing:**
    - Test on different devices (phones, tablets) with various screen sizes and OS versions.

### Test Case Example:

- **Login Test:**
    - Navigate to the login screen.
    - Enter valid/invalid credentials and validate the home screen behavior.

---

## Automated Testing with Appium

### 1. Appium Setup:

Configure **Appium** for both **Android** and **iOS** platforms using **Desired Capabilities**.

```java
// Android Desired Capabilities
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("deviceName", "Android Emulator");
capabilities.setCapability("appPackage", "com.example.app");
capabilities.setCapability("appActivity", ".MainActivity");
capabilities.setCapability("automationName", "UiAutomator2");

// iOS Desired Capabilities
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("platformName", "iOS");
capabilities.setCapability("deviceName", "iPhone 11");
capabilities.setCapability("bundleId", "com.example.app");
capabilities.setCapability("automationName", "XCUITest");
```

### 2. Test Scripts

Here is an example of an automated test script for logging into the app:

```java
@Test
public void testLogin() {
    WebElement usernameField = driver.findElement(By.id("username"));
    WebElement passwordField = driver.findElement(By.id("password"));
    WebElement loginButton = driver.findElement(By.id("loginButton"));
    
    usernameField.sendKeys("testUser");
    passwordField.sendKeys("testPassword");
    loginButton.click();
    
    // Assert Home screen is displayed
    Assert.assertTrue(driver.findElement(By.id("homeScreen")).isDisplayed());
}
```

### 3. Cross-Platform Testing

For cross-platform testing, you can differentiate the behavior for Android and iOS:

```java
@Test
public void testCrossPlatform() {
    if (platformName.equals("Android")) {
        // Android-specific test steps
    } else if (platformName.equals("iOS")) {
        // iOS-specific test steps
    }
}
```

---

## Test Execution

### Running the Tests:

1. **Run Tests Locally:**
   Use **TestNG** to run tests locally by executing the following command:

```bash
mvn test
```

Or using Gradle:

```bash
gradle test
```

2. **Run Tests on Cloud (Optional):**
   Use platforms like **BrowserStack** or **Sauce Labs** for cross-platform testing on real devices.

---

## Reporting

TestNG provides a comprehensive report after test execution. It includes details like:

- Test status (Pass/Fail)
- Test duration
- Failed test logs
- Screenshots (if configured)

To view the TestNG report, navigate to the `target/test-classes/testng.html` file after running the tests.

---

## Contributing

We welcome contributions to this project. Please fork the repository, make your changes, and submit a pull request.

### Steps to Contribute:
1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes.
4. Commit your changes: `git commit -m "Add feature"`.
5. Push to the branch: `git push origin feature-name`.
6. Create a pull request.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

