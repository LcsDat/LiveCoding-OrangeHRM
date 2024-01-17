package pageObjects;

import commons.BasePage;
import commons.PageGenerator;
import interfaces.PIMHeaderPageUI;
import org.openqa.selenium.WebDriver;

public class PIMHeaderPageObject extends BasePage {
    WebDriver driver;
    public PIMHeaderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EmployeeListPageObject openEmployeeListPage(){
        waitForElementClickable(PIMHeaderPageUI.EMPLOYEE_LIST_LINK);
        clickToElement(PIMHeaderPageUI.EMPLOYEE_LIST_LINK);

        return PageGenerator.getEmployeeListPage(driver);
    }
    public AddEmployeePageObject openAddEmployeePage(){
        waitForElementClickable(PIMHeaderPageUI.ADD_EMPLOYEE_LINK);
        clickToElement(PIMHeaderPageUI.ADD_EMPLOYEE_LINK);

        return PageGenerator.getAddEmployeePage(driver);
    }
}
