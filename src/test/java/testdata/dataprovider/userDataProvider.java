package testdata.dataprovider;

import org.testng.annotations.DataProvider;

public class userDataProvider {

    @DataProvider (name = "validLoginCredentials")
    public static Object[][] validLoginCredentials() {
        return new Object[][]{
                {"testuser@example.com", "Parola100!"}
        };
    }

}