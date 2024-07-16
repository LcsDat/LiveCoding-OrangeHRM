package pageObjects;

import commons.BasePage;
import interfaces.UserManagementPageUI;
import org.openqa.selenium.WebDriver;

public class UserManagementPageObject extends BasePage {
    WebDriver driver;
    public UserManagementPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddButton(){
        waitForElementClickable(UserManagementPageUI.ADD_BUTTON);
        clickToElement(UserManagementPageUI.ADD_BUTTON);
    }

    public void selectRole(String role) {
        waitForElementClickable(UserManagementPageUI.USER_ROLE_DROPDOWN);
        selectItemInDropdown(UserManagementPageUI.USER_ROLE_DROPDOWN,UserManagementPageUI.USER_ROLE_OPTION,role);
    }

    public void selectStatus(String status){
        waitForElementClickable(UserManagementPageUI.STATUS_DROPDOWN);
        selectItemInDropdown(UserManagementPageUI.STATUS_DROPDOWN,UserManagementPageUI.STATUS_OPTION,status);
    }

    public String getEmployeeNameErrorMessage() {
        waitForElementVisible(UserManagementPageUI.EMPLOYEE_NAME_ERROR_LABEL);
        return getElementText(UserManagementPageUI.EMPLOYEE_NAME_ERROR_LABEL);
    }

    public void selectEmployeeName(String value) {
        waitForElementClickable(UserManagementPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeysToElement(UserManagementPageUI.EMPLOYEE_NAME_TEXTBOX, value);
        if(isElementDisplayed(UserManagementPageUI.EMPLOYEE_NAME_OPTION)) clickToElement(UserManagementPageUI.EMPLOYEE_NAME_OPTION);
        else clickToElement(UserManagementPageUI.EMPLOYEE_NAME_NOOPTION);
    }

    public void setTexToUsernameTextBox(String value) {
        waitForElementClickable(UserManagementPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(UserManagementPageUI.USERNAME_TEXTBOX,value);
    }

    public String getUsernameErrorMessage() {
        waitForElementVisible(UserManagementPageUI.USERNAME_ERROR_LABEL);
        return getElementText(UserManagementPageUI.USERNAME_ERROR_LABEL);
    }

    public void setTexToPasswordTextBox(String value) {
        waitForElementClickable(UserManagementPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(UserManagementPageUI.PASSWORD_TEXTBOX,value);
    }

    public String getPasswordErrorMessage() {
        waitForElementVisible(UserManagementPageUI.PASSWORD_ERROR_LABEL);
        return getElementText(UserManagementPageUI.PASSWORD_ERROR_LABEL);
    }

    public void setTexToConfirmPasswordTextBox(String value) {
        waitForElementClickable(UserManagementPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(UserManagementPageUI.CONFIRM_PASSWORD_TEXTBOX,value);
    }

    public String getConfirmPasswordErrorMessage() {
        waitForElementVisible(UserManagementPageUI.CONFIRM_PASSWORD_ERROR_LABEL);
        return getElementText(UserManagementPageUI.CONFIRM_PASSWORD_ERROR_LABEL);
    }

    public void clickToSaveButton() {
        waitForElementClickable(UserManagementPageUI.SAVE_BUTTON);
        clickToElement(UserManagementPageUI.SAVE_BUTTON);
    }

    public String getUserRoleErrorMessage() {
        waitForElementVisible(UserManagementPageUI.USER_ROLE_ERROR_LABEL);
        return getElementText(UserManagementPageUI.USERNAME_ERROR_LABEL);
    }

    public String  getStatusErrorMessage() {
        waitForElementVisible(UserManagementPageUI.STATUS_ERROR_LABEL);
        return getElementText(UserManagementPageUI.STATUS_ERROR_LABEL);
    }

    public String getErrorMessage(String labelName){
        waitForElementVisible(UserManagementPageUI.DYNAMIC_ERROR_LABEL, labelName);
        return getElementText(UserManagementPageUI.DYNAMIC_ERROR_LABEL, labelName);
    }
}
