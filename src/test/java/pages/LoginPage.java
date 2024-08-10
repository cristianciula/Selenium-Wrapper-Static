package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static wrappers.SeleniumWrapper.*;

public class LoginPage {

    WebDriver driver;

    //____________________CONSTRUCTOR____________________//
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private final By emailInputField = By.id("email");
    private final By passwordInputField = By.id("pass");
    private final By loginButton = By.xpath("//button[@title=\"Login\"]");

    //____________________METHODS____________________//
    public void enterEmail(String email) {
        sendKeysToElement(emailInputField, email);
    }
    public void enterPassword(String password) {
        clearPasswordField();
        sendKeysToElement(passwordInputField, password);
    }
    public void clickLoginButton() {
        scrollToElement(loginButton);
        clickElement(loginButton);
    }
    public void clearPasswordField() {
        clearElement(passwordInputField);
    }
    public void clearEmailField() {
        clearElement(emailInputField);
    }
    public void clearCredentialFields() {
        clearEmailField();
        clearPasswordField();
    }

}
