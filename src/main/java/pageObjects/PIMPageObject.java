package pageObjects;

import commons.BasePage;
import interfaces.PIMPageUI;
import org.openqa.selenium.WebDriver;

public class PIMPageObject extends PIMHeaderPageObject {

    public PIMPageObject(WebDriver driver) {
        super(driver);
    }

    public void setTextToEmployeeNameTextbox(String value) {
        waitForElementClickable(PIMPageUI.EMPLOYEE_NAME_TEXTBOX);
        sendKeysToElement(PIMPageUI.EMPLOYEE_NAME_TEXTBOX, value);
    }
}
