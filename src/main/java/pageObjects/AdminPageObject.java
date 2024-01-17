package pageObjects;

import interfaces.AdminPageUI;
import org.openqa.selenium.WebDriver;

public class AdminPageObject extends HomeSideMenuPageObject {
    public AdminPageObject(WebDriver driver) {
        super(driver);
    }

    public void setTextToUsernameTextbox(String value) {
        waitForElementClickable(AdminPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(AdminPageUI.USERNAME_TEXTBOX, value);
    }
}
