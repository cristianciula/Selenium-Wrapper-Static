package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.SeleniumWrapper;

import static wrappers.SeleniumWrapper.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //____________________LOCATORS____________________//
    private final By emailInputField = By.id("email");
    private final By passwordInputField = By.id("pass");
    private final By loginButton = By.xpath("//button[@title=\"Login\"]");
    private final By emailEmptyErrorMessage = By.id("advice-required-entry-email");

    //____________________PRIVATE METHODS____________________//



    //____________________PUBLIC METHODS____________________//
    public String getCurrentUrl() {
        return SeleniumWrapper.getCurrentUrl();
    }
    public void enterEmail(String string) {
        sendKeys(emailInputField, string);
    }
    public void enterPassword(String string) {
        sendKeys(passwordInputField, string);
    }
    public void clickLoginButton() {
        scrollToElement(loginButton);
        click(loginButton);
    }
    public void clearPasswordInput() {
        clear(passwordInputField);
    }
    public void clearEmailField() {
        clear(emailInputField);
    }
    public void clearCredentialsInputs() {
        clearEmailField();
        clearPasswordInput();
    }
    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }
    public String getEmailEmptyErrorMessage() {
        return getText(emailEmptyErrorMessage);
    }
    public boolean isEmailFieldDisplayed() {
        return isElementDisplayed(emailInputField);
    }
    public boolean isPasswordFieldDisplayed() {
        return isElementDisplayed(passwordInputField);
    }
}
