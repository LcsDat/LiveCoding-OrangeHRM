import commons.BasePage;
import commons.BaseTest;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
    PersonalDetailsPageObject personalDetailsPage;

    String adminOpenUsername = "Admin";
    String adminOpenPassword = "admin123";
    String adminUsername = "hideyashy";
    String adminPassword = "#Onimusha00";
    String invalidLength = "abcdefghijklmnopqrstuvwxyzABCEFGH";
    String validFirstName = "Dat" + BasePage.getRandomNumber(99999);
    String validLastName = "Le" + BasePage.getRandomNumber(99999);
    String validId = String.valueOf(BasePage.getRandomNumber(9999));

    @Parameters({"browser", "url"})
    @BeforeClass
    public void Before_Test(String browser, String url) {
        driver = getBrowserDriver(browser, url);

        loginPage = PageGenerator.getLoginPage(driver);
//        loginPage.sleepInSecond(5);
    }

    @Description("Resister 01")
    @Story("Add Employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Register_01_First_Name_And_Last_Name_Required() {
        loginPage.setTextToUsernameTextbox(adminUsername);
        loginPage.setTextToPasswordTextbox(adminPassword);
        loginPage.clickToLoginButton();

        homePage = PageGenerator.getHomePage(driver);

        Assert.assertEquals(homePage.getDashboardText(), "Dashboard");

        pimPage = homePage.openpimPage();
//        pimPage.sleepInSecond(10);

        employeeListPage = pimPage.openEmployeeListPage();
        employeeListPage.clickToAddButton();
//        employeeListPage.sleepInSecond(10);

        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        addEmployeePage.clickToSaveButton();
//        addEmployeePage.sleepInSecond(10);

        Assert.assertEquals(addEmployeePage.getFirstNameRequiredErrorMessageText(), "Required");
        Assert.assertEquals(addEmployeePage.getLastNameRequiredErrorMessageText(), "Required");
    }

    @Test
    public void Register_02_First_Name_And_Last_Name_Max_30_Characters() {
        addEmployeePage.setTextToFirstNameTextbox(invalidLength);
        addEmployeePage.setTextToLastNameTextbox(invalidLength);
        addEmployeePage.setTextToId(invalidLength);

        Assert.assertEquals(addEmployeePage.getFirstNameCharacterErrorMessageText(), "Should not exceed 30 characters");
        Assert.assertEquals(addEmployeePage.getLastNameCharacterErrorMessageText(), "Should not exceed 30 characters");
        Assert.assertEquals(addEmployeePage.getIdErrorMessageText(), "Should not exceed 10 characters");
        addEmployeePage.sleepInSecond(5);
    }

    @Test
    public void Register_03_Add_Employee_Successful() {
        addEmployeePage.setTextToFirstNameTextbox(validFirstName);
        addEmployeePage.setTextToLastNameTextbox(validLastName);
        addEmployeePage.setTextToId(validId);
        addEmployeePage.clickToSaveButton();

        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        personalDetailsPage.waitForPersonalPageLoadSuccess();

        Assert.assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
        Assert.assertEquals(personalDetailsPage.getFirstNameTextboxValue(), validFirstName);
        Assert.assertEquals(personalDetailsPage.getLastNameTextboxValue(), validLastName);
        Assert.assertEquals(personalDetailsPage.getIdTextboxValue(), validId);
    }

    @Test
    public void Register_04_Id_Is_Unique() {
        personalDetailsPage.clickToEmployeeListLink();

        employeeListPage = PageGenerator.getEmployeeListPage(driver);

        employeeListPage.clickToAddButton();
        addEmployeePage.setTextToId(validId);
        addEmployeePage.clickToSaveButton();
        addEmployeePage.sleepInSecond(5);

        Assert.assertEquals(addEmployeePage.getDuplicateIdErrorMessageText(), "Employee Id already exists");

    }

    @AfterClass
    public void After_Test() {
        closeBrowser();
    }
}
