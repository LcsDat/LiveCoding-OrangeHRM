package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
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

    public Set<Cookie> getBrowserCookies() {
        return driver.manage().getCookies();
    }

    public void getCookies(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    public By getByLocator(String locatorInterface) {
        By by = null;
        if (locatorInterface.startsWith("XPATH=") || locatorInterface.startsWith("xpath=") || locatorInterface.startsWith("Xpath=") || locatorInterface.startsWith("XPath=") || locatorInterface.startsWith("xPath=")) {
            by = By.xpath(locatorInterface.substring(6));
        } else if (locatorInterface.startsWith("CSS=") || locatorInterface.startsWith("css=") || locatorInterface.startsWith("Css=")) {
            by = By.cssSelector(locatorInterface.substring(4));
        } else if (locatorInterface.startsWith("NAME=") || locatorInterface.startsWith("Name=") || locatorInterface.startsWith("name=")) {
            by = By.name(locatorInterface.substring(5));
        } else if (locatorInterface.startsWith("ID=") || locatorInterface.startsWith("Id=") || locatorInterface.startsWith("id=")) {
            by = By.id(locatorInterface.substring(3));
        } else if (locatorInterface.startsWith("CLASS=") || locatorInterface.startsWith("Class=") || locatorInterface.startsWith("class=")) {
            by = By.className(locatorInterface.substring(6));
        } else if (locatorInterface.startsWith("TAGNAME=") || locatorInterface.startsWith("tagname=") || locatorInterface.startsWith("Tagname=")) {
            by = By.tagName(locatorInterface.substring(8));
        }
        return by;
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }

    public WebElement getWebElement(String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElements(String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElements(String locator, String restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public void clickToElement(String locator) {
        getWebElement(locator).click();
    }

    public void clickToElement(String locator, String... restParams) {
        getWebElement(getDynamicLocator(locator, restParams)).click();
    }

    public void sendKeysToElement(String locator, String value) {
        getWebElement(locator).clear();
        getWebElement(locator).sendKeys(value);
    }

    public void sendKeysToElement(String locator, String value, String... restParams) {
        getWebElement(getDynamicLocator(locator, restParams)).clear();
        getWebElement(getDynamicLocator(locator, restParams)).sendKeys(value);
    }

    public String getElementText(String locator) {
        return getWebElement(locator).getText();
    }

    public String getElementText(String locator, String... restParams) {
        return getWebElement(getDynamicLocator(locator, restParams)).getText();
    }

    public void selectItemInDropdown(String locator, String itemText) {
        new Select(getWebElement(locator)).selectByVisibleText(itemText);
    }

    public void selectItemInDropdown(String locator, String itemText, String... restParams) {
        new Select(getWebElement(getDynamicLocator(locator, restParams))).selectByVisibleText(itemText);
    }

    /**
     * Apply for custom dropdown.
     * Child locators is the list item in the custom dropdown.
     * Parent locator is parent of child locator.
     *
     * @param parentLocator: the combobox locator
     * @param childLocator:  list item of the combobox
     * @param itemText:      visible value of the item
     */
    public void selectItemInDropdown(String parentLocator, String childLocator, String itemText) {
        clickToElement(parentLocator);
        List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));

        for (WebElement element : elements) {
            if (element.getText().equals(itemText)) {
                element.click();
                break;
            }
        }
    }

    public String getElementAttribute(String locator, String attributeValue) {
        return getWebElement(locator).getAttribute(attributeValue);
    }

    public String getElementCSSValue(String locator, String cssProperty) {
        return getWebElement(locator).getCssValue(cssProperty);
    }

    public String convertRGBAToHexaColor(String locator) {
        return Color.fromString(getElementCSSValue(locator, "background-color")).asHex();
    }

    public int getElementSizes(String locator) {
        return getListElements(locator).size();
    }

    public int getElementSizes(String locator, String restParams) {
        return getListElements(getDynamicLocator(locator, restParams)).size();
    }

    /**
     * Apply for checkbox and radio button
     *
     * @param locator
     */
    public void checkToElement(String locator) {
        if (!getWebElement(locator).isSelected()) {
            clickToElement(locator);
        }
    }

    /**
     * Apply for checkbox and radio button
     *
     * @param locator
     * @param restParams
     */
    public void checkToElement(String locator, String restParams) {
        if (!getWebElement(locator).isSelected()) {
            clickToElement(getDynamicLocator(locator, restParams));
        }
    }

    /**
     * Only apply for checkbox
     *
     * @param locator
     */
    public void uncheckToElement(String locator) {
        if (getWebElement(locator).isSelected()) {
            clickToElement(locator);
        }
    }

    public boolean isElementSelected(String locator) {
        return getWebElement(locator).isSelected();
    }

    public void setImplicitWait(long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public boolean isElementDisplayed(String locator) {
        boolean status;
        try {
            status = getWebElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean isElementDisplayed(String locator, String... restParams) {
        boolean status;
        try {
            status = getWebElement(getDynamicLocator(locator, restParams)).isDisplayed();
        } catch (NoSuchElementException e) {
            status = false;
        }
        return status;
    }

    public boolean isElementUndisplayed(String locator) {
        setImplicitWait(GlobalConstant.SHORT_TIMEOUT);
        List<WebElement> elements = getListElements(locator);
        setImplicitWait(GlobalConstant.LONG_TIMEOUT);
        if (elements.size() > 0) {
            return false;
        } else if (elements.size() == 1 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return true;
        }
    }

    public boolean isElemenEnabled(String locator) {
        return getWebElement(locator).isEnabled();
    }

    public void switchToIFrame(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(getWebElement(locator)));
    }

    public void switchToDefaultContent(String locator) {
        driver.switchTo().defaultContent();
    }

    public void hoverToElement(String locator) {
        new Actions(driver).moveToElement(getWebElement(locator)).perform();
    }

    public void doubleClickToElement(String locator) {
        new Actions(driver).doubleClick(getWebElement(locator)).perform();
    }

    public void rightClickToElement(String locator) {
        new Actions(driver).contextClick(getWebElement(locator)).perform();
    }

    public void sendKeyboardToElement(String locator, Keys value) {
        new Actions(driver).sendKeys(getWebElement(locator), value).perform();
    }

    public void dragAndDropElement(String sourcelocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(sourcelocator), getWebElement(targetLocator)).perform();
    }

    public Object executeForBrowser(String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(String expectedText) {
        String actualText = (String) ((JavascriptExecutor) driver).executeScript(
                "return document.documentElement.innerText.match('" + expectedText + "')[0];");
        return actualText.equals(expectedText);
    }

    public void scrollToBottomPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void highlightElement(String locator) {
        WebElement element = getWebElement(locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style',arguments[1])",
                "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].scrollIntoView(true);", getWebElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].scrollIntoView(false);", getWebElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
                getWebElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(locator));
    }

    public void sendKeysToElementByJS(String locator, String value) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('value', '" + value + "')", getWebElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].getAttribute('" + attributeName + "');", getWebElement(locator));
    }

    public String getWebElementValidationMessage(String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].validationMessage;", getWebElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(locator));
    }


    public void waitForElementVisible(String locator) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(String locator, String... restParams) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForListElementVisible(String locator) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.visibilityOfAllElements(getListElements(locator)));
    }

    public void waitForElementInvisible(String locator) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(String locator, String... restParams) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementInvisible(WebElement element) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.invisibilityOf(element));
    }

    public void waitForListElementInvisible(String locator) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.invisibilityOfAllElements(getListElements(locator)));
    }

    public void waitForElementClickable(String locator) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementClickable(String locator, String... restParams) {
        new WebDriverWait(driver,
                Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT)).until(
                ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {

                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }

        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public void uploadMultipleFiles(String... fileNames) {
        String filePath = GlobalConstant.UPLOAD_PATH;
        String fullFileName = "";

        for (String fileName : fileNames) {
            fullFileName = fullFileName + filePath + fileName + "\n";
        }

        fullFileName = fullFileName.trim();
        getWebElement("//input[@type='file']").sendKeys(fullFileName);
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getRandomNumber(int boundary){
        return new Random().nextInt(boundary);
    }
}
