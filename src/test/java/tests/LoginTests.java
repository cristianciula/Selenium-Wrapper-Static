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

    @Test(description = "User can login by entering a valid Email and a valid Password.",
            dataProvider = "validLoginCredentials", dataProviderClass = DataProviders.class)
    public void canLoginWithValidCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        assertTrue(accountDashboardPage.getContactInfoEmail().contains(email));
    }

}
