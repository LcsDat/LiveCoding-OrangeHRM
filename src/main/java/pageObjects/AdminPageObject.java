package pageObjects;

import commons.BasePage;
import interfaces.AdminPageUI;
import org.openqa.selenium.WebDriver;

public class AdminPageObject extends BasePage {

    public AdminPageObject(WebDriver driver) {
        super(driver);
    }

    public void setTextToUsernameTextbox(String value) {
        waitForElementClickable(AdminPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(AdminPageUI.USERNAME_TEXTBOX, value);
    }

    public void clickToPimLink() {
        waitForElementClickable(AdminPageUI.PIM_LINK);
        clickToElement(AdminPageUI.PIM_LINK);
    }
}
