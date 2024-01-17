import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class PIM_Add_Employee extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    HomePageObject homePage;
    PIMPageObject pimPage;
    EmployeeListPageObject employeeListPage;
    AddEmployeePageObject addEmployeePage;

    String adminUsername = "Admin";
    String adminPassword = "admin123";
    String invalidNameLength = "abcdefghijklmnopqrstuvwxyzABCEFGH";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void Before_Test(String browser, String url) {
        driver = getBrowserDriver(browser, url);

        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.sleepInSecond(5);
    }

    @Test
    public void Register_01_Verify_First_Name_And_Last_Name_Required() {
        loginPage.setTextToUsernameTextbox(adminUsername);
        loginPage.setTextToPasswordTextbox(adminPassword);
        loginPage.clickToLoginButton();

        homePage = PageGenerator.getHomePage(driver);

        Assert.assertEquals(homePage.getDashboardText(), "Dashboard");

        pimPage = homePage.openpimPage();
        pimPage.sleepInSecond(10);

        employeeListPage = pimPage.openEmployeeListPage();
        employeeListPage.clickToAddButton();
        employeeListPage.sleepInSecond(10);

        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        addEmployeePage.clickToSaveButton();
        addEmployeePage.sleepInSecond(10);

        Assert.assertEquals(addEmployeePage.getFirstNameRequiredErrorMessageText(),"Required");
        Assert.assertEquals(addEmployeePage.getLastNameRequiredErrorMessageText(),"Required");
    }

    @Test
    public void Register_02_Verify_First_Name_And_Last_Name_Max_30_Characters() {
        addEmployeePage.setTextToFirstNameTextbox(invalidNameLength);
        addEmployeePage.setTextToLastNameTextbox(invalidNameLength);

        Assert.assertEquals(addEmployeePage.getFirstNameCharacterErrorMessageText(),"Should not exceed 30 characters");
        Assert.assertEquals(addEmployeePage.getLastNameCharacterErrorMessageText(),"Should not exceed 30 characters");
    }

    @AfterClass
    public void After_Test() {
        closeBrowser();
    }
}
