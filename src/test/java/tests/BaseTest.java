package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import wrappers.SeleniumWrapper;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public static LoginPage loginPage;
    public static AccountDashboardPage accountDashboardPage;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--start-maximized " +
                "--disable-search-engine-choice-screen"
        );

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        SeleniumWrapper.setDriver(driver);

        loginPage = new LoginPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);

    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }

        loginPage = null;
        accountDashboardPage = null;
    }
}
