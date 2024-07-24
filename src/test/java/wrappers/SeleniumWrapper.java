package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public final class SeleniumWrapper {

    private static WebDriver driver;
    public static void setDriver(WebDriver driver) {
        SeleniumWrapper.driver = driver;
    }

    //____________________PRIVATE METHODS____________________//



    //____________________PUBLIC METHODS____________________//
    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public static void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void clickElement(By by) {
        scrollToElement(by);
        driver.findElement(by).click();
    }

    public static void clearElement(By by) {
        scrollToElement(by);
        driver.findElement(by).clear();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static String getElementText(By by) {
        scrollToElement(by);
        return driver.findElement(by).getText();
    }

    public static boolean isElementDisplayed(By by) {
        scrollToElement(by);
        return driver.findElement(by).isDisplayed();
    }

    public static boolean isElementSelected(By by) {
        scrollToElement(by);
        return driver.findElement(by).isSelected();
    }

    public static boolean isElementEnabled(By by) {
        scrollToElement(by);
        return driver.findElement(by).isEnabled();
    }

    public static void sendKeysToElement(By by, String string) {
        scrollToElement(by);
        driver.findElement(by).sendKeys(string);
    }

    public static void hoverOverElement(By by) {
        Actions actions = new Actions(driver);
        scrollToElement(by);
        actions.moveToElement(driver.findElement(by));
        actions.build().perform();
    }

    public static void dragAndDropElement(By by, By target) {
        Actions actions = new Actions(driver);
        scrollToElement(by);
        actions.dragAndDrop((WebElement) by, (WebElement) target);
        actions.build().perform();
    }
    //TODO: Create custom waiter method to wait for a specific exact "string" if the value of that webelement is updated later than the element itself is displayed. Can potentially also add wait time as well.
    // Method can contain following parameters: (expectedText, waitTimeInSeconds)

}
