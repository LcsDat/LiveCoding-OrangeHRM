package pageObjects;

import interfaces.PersonalDetailsPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPageObject extends EmployeeListPageObject{
    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isPersonalDetailsHeaderDisplayed(){
        return isElementDisplayed(PersonalDetailsPageUI.PERSONAL_DETAILS_HEADER);
    }

    @Step("Get value of First Name text box")
    public String getFirstNameTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailsPageUI.FIRSTNAME_TEXTBOX,"value");
    }

    @Step("Get value of Last Name text box")
    public String getLastNameTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailsPageUI.LASTNAME_TEXTBOX,"value");
    }

    @Step("Get value of ID text box")
    public String getIdTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.ID_TEXTBOX);
        return getElementAttribute(PersonalDetailsPageUI.ID_TEXTBOX,"value");
    }

    public void waitForPersonalPageLoadSuccess(){
        waitForElementInvisible(PersonalDetailsPageUI.ICON_LOADING);
    }

    @Step("Click to Employee List link")
    public void clickToEmployeeListLink() {
        waitForElementClickable(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
        clickToElement(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
    }
}
