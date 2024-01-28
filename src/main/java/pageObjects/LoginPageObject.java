package pageObjects;

import commons.BasePage;
import interfaces.LoginPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Input username textbox with value: {0}")
    public void setTextToUsernameTextbox(String value) {
        waitForElementClickable(LoginPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(LoginPageUI.USERNAME_TEXTBOX,value);
    }

    public void setTextToPasswordTextbox(String value) {
        waitForElementClickable(LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(LoginPageUI.PASSWORD_TEXTBOX,value);
    }

    public void clickToLoginButton() {
        waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
    }
}
