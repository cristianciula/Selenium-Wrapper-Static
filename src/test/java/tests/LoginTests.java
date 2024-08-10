package tests;

import testdata.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import constants.URL;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        driver.get(URL.LOGIN_PAGE);
    }

    @Test(description = "User can login using valid credentials.",
            dataProvider = "validLoginCredentials", dataProviderClass = DataProviders.class,
            invocationCount = 5)
    public void canLoginWithValidCredentials(String email, String password) {
        loginPage.clearCredentialFields();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertTrue(accountDashboardPage.getContactInfoEmail().contains(email));

    }

}
