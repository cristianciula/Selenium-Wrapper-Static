package testdata;

public class DataProviders {

    @org.testng.annotations.DataProvider(name = "validLoginCredentials")
    public static Object[][] validLoginCredentials() {
        return new Object[][]{
                {"testuser@example.com", "Parola100!"}
        };
    }

}