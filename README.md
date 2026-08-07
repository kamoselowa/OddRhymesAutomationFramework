# OddRhymes Automation Framework

Selenium WebDriver + TestNG automation framework built from scratch to test **OddRhymes.com**.

**Target App:** [https://oddrhymes.com](https://oddrhymes.com)  
**Author:** Kamogelo Selowa ([@kamoselowa](https://github.com/kamoselowa))  
**Status:** Active Development

---

## About the Project

This framework automates critical user flows of OddRhymes — a creative platform for rappers, lyricists, poets, and spoken-word artists.

**OddRhymes features:**
- Verse & poetry sharing
- Text-based and live rap battles
- Live audio/video sessions
- Community feed and artist profiles
- Notifications and dark mode

The goal of this framework is to find defects, reduce manual testing effort, and keep growing as the platform expands.

---

## Tech Stack

| Technology           | Version   | Purpose                        |
|----------------------|-----------|--------------------------------|
| Java                 | 17        | Programming language           |
| Selenium WebDriver   | 4.43.0    | Browser automation             |
| TestNG               | 7.12.0    | Test framework                 |
| Maven                | -         | Build tool                     |
| Apache POI           | 5.5.0     | Excel data-driven testing      |
| WebDriverManager     | 5.8.0     | Driver management              |
| Log4j                | 2.23.1    | Logging                        |

**Supported Browsers:** Chrome (default), Firefox, Edge

---

## Project Structure

```
OddRhymesAutomationFramework/
└── selenium-framework/
    ├── pom.xml
    ├── src/
    │   ├── main/java/com/automation/
    │   │   ├── base/               → BasePage.java
    │   │   ├── pages/              → RegistrationPage.java, SignInPage.java
    │   │   └── utils/              → ConfigReader.java, Customwait.java
    │   │
    │   └── test/java/com/automation/
    │       ├── basetest/           → BaseTest.java
    │       ├── dataproviders/      → Data providers for TestNG
    │       ├── testdatareaders/    → ExcelReader.java
    │       ├── tests/
    │       │   ├── registration/   → Registration test cases
    │       │   └── signin/         → Sign-in test cases
    │       └── Resources/
    │           └── Configurations/
    │               ├── config.properties
    │               └── Test-Data/  → Excel files
    │
    └── Test-Plan/
        └── test plan.pdf
```

---

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- Git
- Chrome / Firefox / Edge browser

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/kamoselowa/OddRhymesAutomationFramework.git
cd OddRhymesAutomationFramework/selenium-framework
```

### 2. Configure
Edit the file:
`src/test/java/com/automation/Resources/Configurations/config.properties`

```properties
URL = https://oddrhymes.com
BROWSER = Chrome
GLOBALWAIT = 60
FIELDS_VERIFICATION_EXCEL = Test_Data_Fields_Verification.xlsx
```

### 3. Install Dependencies
```bash
mvn clean install -DskipTests
```

### 4. Run Tests
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=ValidLogin
```

---

## Current Test Coverage

### Sign-In Module
- Valid Login
- Empty Email / Empty Password
- Invalid Credentials
- Forgot Password
- Create Account redirect
- Page Title & Element verification
- Server Error scenarios

### Registration Module
- Successful Registration
- Empty Email / Empty Password
- Invalid Email Format
- Existing Email
- Weak Password
- Sign-In redirect
- Server Error scenarios

> More modules (Feed, Battles, Live Sessions, Profile) are planned.

---

## Design Patterns Used

- **Page Object Model (POM)**
- **BaseTest + BasePage** for setup/teardown and driver management
- **Custom Explicit Waits** (`Customwait`)
- **Data-Driven Testing** using Excel + TestNG DataProviders
- **Externalized Configuration** via `config.properties`

---

## Known Findings

The framework has already helped uncover real application defects, including:

- Weak passwords are currently accepted during registration

---

## Future Improvements

- [ ] Page Objects for Feed, Profile, Battles, and Live features
- [ ] Proper Log4j implementation
- [ ] ExtentReports / Allure reporting
- [ ] Parallel execution support
- [ ] Cross-browser execution via TestNG XML
- [ ] CI/CD integration (GitHub Actions)
- [ ] Screenshot on failure
- [ ] Selenium Grid support

---

## Test Plan

A formal test plan is available at:

`src/Test-Plan/test plan.pdf`

---

## Author

**Kamogelo Selowa**  
GitHub: [@kamoselowa](https://github.com/kamoselowa)

Built for the culture — from Johannesburg to the metaverse.

---

**Made for the bars. Built for the culture.**
```
