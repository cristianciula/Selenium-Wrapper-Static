package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.*;
import helpers.SeleniumHelper;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public static LoginPage loginPage;
    public static AccountDashboardPage accountDashboardPage;

    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearDown() {
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        loginPage = new LoginPage(driver);
        accountDashboardPage = new AccountDashboardPage(driver);

        SeleniumHelper.setDriver(driver);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
