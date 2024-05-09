package tests;

import components.Header;
import components.MenuBar;
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

    public static Header header;
    public static MenuBar menuBar;
    public static LoginPage loginPage;

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

        header = new Header(driver);
        menuBar = new MenuBar(driver);
        loginPage = new LoginPage(driver);

        SeleniumWrapper.setDriver(driver);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
