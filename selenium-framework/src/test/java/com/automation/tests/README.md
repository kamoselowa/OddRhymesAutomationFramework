# Test Case Catalog

This catalog describes the Java test classes currently under `signin/` and
`registration/`. It documents what the code does today, including incomplete
tests and cases where the implementation may not match the test name.

## Shared test setup

All active test classes extend `BaseTest`. Before each test, the framework
loads `URL` and `BROWSER` from
`src/test/java/com/automation/Resources/Configurations/config.properties`,
opens the configured browser, navigates to the configured URL, and initializes
the page objects. It closes the browser after each test.

Tests that use a TestNG data provider read their inputs from
`src/test/java/com/automation/Resources/Configurations/Test-Data/Test_Data_Fields_Verification.xlsx`.

## Sign-in tests

| Test file | Current behavior |
|---|---|
| [`signin/ValidLogin.java`](./signin/ValidLogin.java) | Uses the `ValidLoginCredentials` Excel data set to sign in and expects navigation to the configured user's profile URL. |
| [`signin/EmptyEmail.java`](./signin/EmptyEmail.java) | Submits the sign-in form without entering credentials and expects the message `Please fill in both fields.` The current code leaves both fields blank. |
| [`signin/EmptyPassword.java`](./signin/EmptyPassword.java) | Submits the sign-in form without entering credentials and expects the message `Please fill in both fields.` The current code leaves both fields blank, so it overlaps with `EmptyEmail.java` rather than testing only an empty password. |
| [`signin/InvalidCredentials.java`](./signin/InvalidCredentials.java) | Uses the `Login` Excel data set and expects the exact error message `Invalid email or password`. |
| [`signin/ServerError.java`](./signin/ServerError.java) | Requires Chrome. Simulates an offline browser network, submits dummy sign-in credentials, and expects a non-empty `.error-message` element. |
| [`signin/ForgotPassword.java`](./signin/ForgotPassword.java) | Clicks the Forgot Password control and checks that the current URL contains `login`. |
| [`signin/CreateAccountClick.java`](./signin/CreateAccountClick.java) | Clicks Create Account and expects the URL to be `https://oddrhymes.com/signup`. |
| [`signin/VerifyTitle.java`](./signin/VerifyTitle.java) | Checks that the sign-in page and logo are displayed and that the page heading is `Odd Rhymes`. |

## Registration tests

| Test file | Current behavior |
|---|---|
| [`registration/SuccessfulRegistration.java`](./registration/SuccessfulRegistration.java) | Uses the `NewUser` Excel data set to submit a registration, checks the profile page, and expects navigation to a profile URL. |
| [`registration/SignInRedirect.java`](./registration/SignInRedirect.java) | Opens the registration page, clicks its sign-in control, and expects `https://oddrhymes.com/login`. |
| [`registration/EmptyEmail.java`](./registration/EmptyEmail.java) | Uses the `registrationData` provider (the `NewUser` Excel data set), fills the form, and expects the email field to be invalid. Check that the selected data actually has a blank email for this scenario. |
| [`registration/EmptyPassword.java`](./registration/EmptyPassword.java) | Uses the `EmptyRegisterPassword` Excel data set, fills the registration form, and expects the password field to be invalid. |
| [`registration/PasswordTooWeak.java`](./registration/PasswordTooWeak.java) | Uses the `PasswordWeaknessTest` Excel data set and expects the browser to remain on a URL containing `register` after submission. |
| [`registration/ExistingEmail.java`](./registration/ExistingEmail.java) | Uses the `NewUser` Excel data set and submits the registration form. It currently has no assertion verifying that an existing email is rejected. |
| [`registration/InvalidEmailFormat.java`](./registration/InvalidEmailFormat.java) | Incomplete: the test method is empty and makes no assertions. |
| [`registration/ServerError.java`](./registration/ServerError.java) | Inactive placeholder: the class and its contents are commented out, so it does not currently define a runnable test. |

## Running tests

Run one class from the `selenium-framework` directory:

```powershell
mvn -Dtest=ValidLogin test
```

Replace `ValidLogin` with the test class name, without `.java`, for another
test. `ServerError` uses Chrome-specific DevTools commands and therefore
requires `BROWSER=Chrome`.

Maven Surefire is configured to discover Java classes under the `tests/`
package, so `mvn verify` runs these test classes in CI. Use the explicit
`-Dtest=ClassName` command above to run an individual class locally.
