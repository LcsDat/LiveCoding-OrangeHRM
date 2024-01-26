package pageObjects;

import commons.BasePage;
import commons.PageGenerator;
import interfaces.PIMHeaderPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PIMHeaderPageObject extends BasePage {
    WebDriver driver;

    public PIMHeaderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Open Employee List Page")
    public EmployeeListPageObject openEmployeeListPage() {
        waitForElementClickable(PIMHeaderPageUI.EMPLOYEE_LIST_LINK);
        clickToElement(PIMHeaderPageUI.EMPLOYEE_LIST_LINK);

        return PageGenerator.getEmployeeListPage(driver);
    }

    public AddEmployeePageObject openAddEmployeePage() {
        waitForElementClickable(PIMHeaderPageUI.ADD_EMPLOYEE_LINK);
        clickToElement(PIMHeaderPageUI.ADD_EMPLOYEE_LINK);

        return PageGenerator.getAddEmployeePage(driver);
    }
}
