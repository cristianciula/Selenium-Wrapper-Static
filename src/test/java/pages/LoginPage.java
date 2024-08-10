package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.SeleniumHelper.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private final By emailInputField = By.id("email");
    private final By passwordInputField = By.id("pass");
    private final By loginButton = By.xpath("//button[@title=\"Login\"]");

    //____________________METHODS____________________//
    public void enterEmail(String string) {
        sendKeysToElement(emailInputField, string);
    }
    public void enterPassword(String string) {
        sendKeysToElement(passwordInputField, string);
    }
    public void clickLoginButton() {
        scrollToElement(loginButton);
        clickElement(loginButton);
    }
    public void clearPasswordInput() {
        clearElement(passwordInputField);
    }
    public void clearEmailField() {
        clearElement(emailInputField);
    }
    public void clearCredentialsInputs() {
        clearEmailField();
        clearPasswordInput();
    }

}
