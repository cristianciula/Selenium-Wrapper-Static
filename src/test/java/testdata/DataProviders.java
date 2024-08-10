package testdata;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "validLoginCredentials")
    public static Object[][] validLoginCredentials() {
        return new Object[][]{
                {"testuser@example.com", "Parola100!"}
        };
    }

}