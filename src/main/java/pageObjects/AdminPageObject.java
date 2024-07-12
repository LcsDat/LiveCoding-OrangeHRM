package pageObjects;

import commons.BasePage;
import interfaces.AdminPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AdminPageObject extends AdminHeaderPageObject {


    public AdminPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Set text {0} to Username text box")
    public void setTextToUsernameTextbox(String value) {
        waitForElementClickable(AdminPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(AdminPageUI.USERNAME_TEXTBOX, value);
    }

}
