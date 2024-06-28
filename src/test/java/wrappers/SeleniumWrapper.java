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

}
