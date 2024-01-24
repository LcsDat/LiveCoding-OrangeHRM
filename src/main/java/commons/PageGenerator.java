package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageGenerator {


    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static AdminPageObject getAdminPage(WebDriver driver) {
        return new AdminPageObject(driver);
    }

    public static PIMPageObject getPIMPage(WebDriver driver) {
        return new PIMPageObject(driver);
    }

    public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPageObject(driver);
    }

    public static AddEmployeePageObject getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePageObject(driver);
    }

    public static PersonalDetailsPageObject getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPageObject(driver);
    }
}
