package pageObjects;

import commons.BasePage;
import interfaces.EmployeeListPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class EmployeeListPageObject extends BasePage {
    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
    }

    @Step("Click to Add button")
    public void clickToAddButton() {
        waitForElementClickable(EmployeeListPageUI.ADD_BUTTON);
        clickToElement(EmployeeListPageUI.ADD_BUTTON);
    }
}
