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
    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public static void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(locator));
    }

    public static void getUrl(String url) {
        driver.get(url);
    }

    public static void clickElement(By locator) {
        scrollToElement(locator);
        driver.findElement(locator).click();
    }

    public static void clearElement(By locator) {
        scrollToElement(locator);
        driver.findElement(locator).clear();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static String getElementText(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).getText();
    }

    public static boolean isElementDisplayed(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).isDisplayed();
    }

    public static boolean isElementSelected(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).isSelected();
    }

    public static boolean isElementEnabled(By locator) {
        scrollToElement(locator);
        return driver.findElement(locator).isEnabled();
    }

    public static void sendKeysToElement(By locator, String text) {
        scrollToElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public static void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        scrollToElement(locator);
        actions.moveToElement(driver.findElement(locator));
        actions.build().perform();
    }

    public static void dragAndDropElement(By sourceLocator, By targetLocator) {
        Actions actions = new Actions(driver);
        scrollToElement(sourceLocator);
        actions.dragAndDrop((WebElement) sourceLocator, (WebElement) targetLocator);
        actions.build().perform();
    }

}
