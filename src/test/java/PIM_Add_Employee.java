import commons.BasePage;
import commons.BaseTest;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.ActionHelper;

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

    @Parameters({"browser", "url2"})
    @BeforeClass
    public void Before_Test(String browser, String url) {
        driver = getBrowserDriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);
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

        verifyEquals(homePage.getDashboardText(), "Dashboard");

        pimPage = homePage.openpimPage();

        employeeListPage = pimPage.openEmployeeListPage();
        employeeListPage.clickToAddButton();

        addEmployeePage = pimPage.openAddEmployeePage();

        addEmployeePage.waitForIconLoadSuccess();
        addEmployeePage.clickToSaveButton();
        verifyEquals(addEmployeePage.getFirstNameRequiredErrorMessageText(), "Required");
        verifyEquals(addEmployeePage.getLastNameRequiredErrorMessageText(), "Required");
    }

    @Description("Register 02")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void Register_02_First_Name_And_Last_Name_Max_30_Characters() {
        addEmployeePage.setTextToFirstNameTextbox(invalidLength);
        addEmployeePage.setTextToLastNameTextbox(invalidLength);
        addEmployeePage.setTextToId(invalidLength);
        verifyEquals(addEmployeePage.getFirstNameCharacterErrorMessageText(), "Should not exceed 30 characters");
        verifyEquals(addEmployeePage.getLastNameCharacterErrorMessageText(), "Should not exceed 30 characters");
        verifyEquals(addEmployeePage.getIdErrorMessageText(), "Should not exceed 10 characters");
    }

    @Severity(SeverityLevel.MINOR)
    @Test
    public void Register_03_Add_Employee_Successful() {
        addEmployeePage.setTextToFirstNameTextbox(validFirstName);
        addEmployeePage.setTextToLastNameTextbox(validLastName);
        addEmployeePage.setTextToId(validId);
        addEmployeePage.clickToSaveButton();

        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        personalDetailsPage.waitForPersonalPageLoadSuccess();

        verifyTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
        verifyEquals(personalDetailsPage.getFirstNameTextboxValue(), validFirstName);
        verifyEquals(personalDetailsPage.getLastNameTextboxValue(), validLastName);
        verifyEquals(personalDetailsPage.getIdTextboxValue(), validId);
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Register_04_Id_Is_Unique() {
        personalDetailsPage.clickToEmployeeListLink();

        employeeListPage = PageGenerator.getEmployeeListPage(driver);

        employeeListPage.clickToAddButton();
        addEmployeePage.setTextToId(validId);
        addEmployeePage.clickToSaveButton();
        addEmployeePage.sleepInSecond(5);

        verifyEquals(addEmployeePage.getDuplicateIdErrorMessageText(), "Employee Id already exists");
    }

    @AfterClass
    public void After_Test() {
        closeBrowser();
    }
}
