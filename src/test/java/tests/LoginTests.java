package tests;

import testdata.dataprovider.userDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "User entering valid Email and valid Password CAN login.",
            dataProvider = "validLoginCredentials", dataProviderClass = userDataProvider.class)
    public void canLoginWithValidCredentials(String email, String password) {
        loginPage.clearCredentialsInputs();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        header.logoutUser();
    }

    @Test(description = "User leaving the Email and Password fields empty CANNOT login.")
    public void cannotLoginWithEmptyCredentials() {
        loginPage.clearCredentialsInputs();
        loginPage.clickLoginButton();

        assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed.");
    }
}
