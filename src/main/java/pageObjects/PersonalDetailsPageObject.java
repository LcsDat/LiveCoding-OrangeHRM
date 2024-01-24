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
        return getElementCSSValue(PersonalDetailsPageUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.LASTNAME_TEXTBOX);
        return getElementCSSValue(PersonalDetailsPageUI.LASTNAME_TEXTBOX,"value");
    }

    public String getIdTextboxValue() {
        waitForElementVisible(PersonalDetailsPageUI.ID_TEXTBOX);
        return getElementCSSValue(PersonalDetailsPageUI.ID_TEXTBOX,"value");
    }
}
