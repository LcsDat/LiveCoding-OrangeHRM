package pageObjects;

import interfaces.PersonalDetailsPageUI;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPageObject extends EmployeeListPageObject{
    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
    }

    public boolean isPersonalDetailsHeaderDisplayed(){
        return isElementDisplayed(PersonalDetailsPageUI.PERSONAL_DETAILS_HEADER);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailsPageUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(PersonalDetailsPageUI.LASTNAME_TEXTBOX,"value");
    }

    public String getIdTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.ID_TEXTBOX);
        return getElementAttribute(PersonalDetailsPageUI.ID_TEXTBOX,"value");
    }

    public void waitForPersonalPageLoadSuccess(){
        waitForElementInvisible(PersonalDetailsPageUI.ICON_LOADING);
    }

    public void clickToEmployeeListLink() {
        waitForElementClickable(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
        clickToElement(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
    }
}
