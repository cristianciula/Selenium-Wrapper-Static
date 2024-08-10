package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static wrappers.SeleniumWrapper.*;

public class AccountDashboardPage {

    WebDriver driver;

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private final By contactInfoEmail = By.xpath("//div[@class=\"dashboard\"]/descendant::p[contains(.,\"testuser@example.com\")]");

    //____________________PRIVATE METHODS____________________//

    //____________________PUBLIC METHODS____________________//
    public String getContactInfoEmail() {
        return getElementText(contactInfoEmail);
    }
}
