package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSourceCode() {
        return driver.getPageSource();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public void forwardToPage() {
        driver.navigate().forward();
    }

    public void refreshToPage() {
        driver.navigate().refresh();
    }

    public void acceptToAlert() {
        waitForAlertPresence().accept();
    }

    public void cancelToAlert() {
        waitForAlertPresence().dismiss();
    }

    public void sendKeysToAlert(String value) {
        waitForAlertPresence().sendKeys(value);
    }

    public void getTextToAlert() {
        waitForAlertPresence().getText();
    }

    public Alert waitForAlertPresence() {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void switchToWindowByID(String expectedWindowID) {
        Set<String> windowIDs = driver.getWindowHandles();
        for (String windowID : windowIDs) {

            if (!windowID.equals(expectedWindowID)) {
                driver.switchTo().window(windowID);
                sleepInSecond(1);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedTitle) {
        Set<String> windowIDs = driver.getWindowHandles();
        for (String windowID : windowIDs) {
            driver.switchTo().window(windowID);
            if (driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowsExceptWindow(String windowTitle) {
        Set<String> windowIDs = driver.getWindowHandles();
        String expectedWindow = null;
        for (String windowID : windowIDs) {
            driver.switchTo().window(windowID);
            String winTitle = driver.getTitle();
            if (!winTitle.equals(windowTitle)) {
                driver.close();
            } else {
                expectedWindow = windowID;
            }
        }
        driver.switchTo().window(expectedWindow);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
