package pageObjects;

import commons.BasePage;
import interfaces.AddEmployeePageUI;
import interfaces.AdminPageUI;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends BasePage {
    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
    }

    public void clickToSaveButton() {
        waitForElementClickable(AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(AddEmployeePageUI.SAVE_BUTTON);
    }

    public String getFirstNameRequiredErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.FIRST_NAME_REQUIRED_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.FIRST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    public String getLastNameRequiredErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.LAST_NAME_REQUIRED_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.LAST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    public String getFirstNameCharacterErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.FIRST_NAME_CHARACTER_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.FIRST_NAME_CHARACTER_ERROR_MESSAGE);
    }

    public String getLastNameCharacterErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.LAST_NAME_CHARACTER_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.LAST_NAME_CHARACTER_ERROR_MESSAGE);
    }

    public void setTextToFirstNameTextbox(String value) {
        waitForElementClickable(AddEmployeePageUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(AddEmployeePageUI.FIRST_NAME_TEXTBOX,value);
    }

    public void setTextToLastNameTextbox(String value) {
        waitForElementClickable(AddEmployeePageUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(AddEmployeePageUI.LAST_NAME_TEXTBOX,value);
    }

    public void setTextToId(String value) {
        waitForElementClickable(AddEmployeePageUI.ID_TEXTBOX);
        sendKeysToElement(AddEmployeePageUI.ID_TEXTBOX,value);
    }

    public String getIdErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.ID_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.ID_ERROR_MESSAGE);
    }

    public String getDuplicateIdErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.ID_DUPLICATE_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.ID_DUPLICATE_ERROR_MESSAGE);
    }
}
