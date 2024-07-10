package pageObjects;

import commons.BasePage;
import interfaces.AddEmployeePageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends BasePage {
    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Click to Save button")
    public void clickToSaveButton() {
        waitForElementClickable(AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(AddEmployeePageUI.SAVE_BUTTON);
    }

    @Step("Get Error message: First Name Required")
    public String getFirstNameRequiredErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.FIRST_NAME_REQUIRED_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.FIRST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    @Step("Get Error message: Last Name Required")
    public String getLastNameRequiredErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.LAST_NAME_REQUIRED_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.LAST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    @Step("Get Error message: Should not exceed 30 characters (First Name)")
    public String getFirstNameCharacterErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.FIRST_NAME_CHARACTER_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.FIRST_NAME_CHARACTER_ERROR_MESSAGE);
    }

    @Step("Get Error message: Should not exceed 30 characters (Last Name)")
    public String getLastNameCharacterErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.LAST_NAME_CHARACTER_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.LAST_NAME_CHARACTER_ERROR_MESSAGE);
    }

    @Step("Set text {0} to First Name text box")
    public void setTextToFirstNameTextbox(String value) {
        waitForElementClickable(AddEmployeePageUI.FIRST_NAME_TEXTBOX);
        sendKeysToElement(AddEmployeePageUI.FIRST_NAME_TEXTBOX,value);
    }

    @Step("Set text {0} to Last Name text box")
    public void setTextToLastNameTextbox(String value) {
        waitForElementClickable(AddEmployeePageUI.LAST_NAME_TEXTBOX);
        sendKeysToElement(AddEmployeePageUI.LAST_NAME_TEXTBOX,value);
    }

    @Step("Set text {0} to ID text box")
    public void setTextToId(String value) {
        waitForElementClickable(AddEmployeePageUI.ID_TEXTBOX);
        sendKeysToElement(AddEmployeePageUI.ID_TEXTBOX,value);
    }

    @Step("Get Error message: Should not exceed 10 characters (ID)")
    public String getIdErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.ID_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.ID_ERROR_MESSAGE);
    }

    @Step("Get Error message: Employee Id already exists (ID)")
    public String getDuplicateIdErrorMessageText() {
        waitForElementVisible(AddEmployeePageUI.ID_DUPLICATE_ERROR_MESSAGE);
        return getElementText(AddEmployeePageUI.ID_DUPLICATE_ERROR_MESSAGE);
    }

    @Step("Wait Add Employee Page load success")
    public void waitForIconLoadSuccess() {
        waitForElementInvisible(AddEmployeePageUI.ICON_LOADING);
    }
}
