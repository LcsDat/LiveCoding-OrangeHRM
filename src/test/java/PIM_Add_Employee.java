import commons.BasePage;
import commons.BaseTest;
import commons.PageGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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
        log.info("Register 01 - Step 01: Set " + adminOpenPassword +" to Username text box.");
        loginPage.setTextToUsernameTextbox(adminOpenUsername);

        log.info("Register 01 - Step 02: Set text to Password text box.");
        loginPage.setTextToPasswordTextbox(adminOpenPassword);

        log.info("Register 01 - Step 03: Click to Login button.");
        loginPage.clickToLoginButton();

        homePage = PageGenerator.getHomePage(driver);

        log.info("Register 01 - Step 04: Verify Dashboard page have Dashboard header.");
        verifyEquals(homePage.getDashboardText(), "Dashboard");


        pimPage = homePage.openpimPage();
//        pimPage.sleepInSecond(10);

        log.info("Register 01 - Step 05: Navigate to PIM page.");
        employeeListPage = pimPage.openEmployeeListPage();

        log.info("Register 01 - Step 06: Click to Add button.");
        employeeListPage.clickToAddButton();

        addEmployeePage = PageGenerator.getAddEmployeePage(driver);

        addEmployeePage.waitForIconLoadSuccess();

        log.info("Register 01 - Step 07: Click to Save Button.");
        addEmployeePage.clickToSaveButton();

        log.info("Register 01 - Step 08: Verify First Name is required.");
        verifyEquals(addEmployeePage.getFirstNameRequiredErrorMessageText(), "Required.");

        log.info("Register 01 - Step 09: Verify Last Name is required.");
        verifyEquals(addEmployeePage.getLastNameRequiredErrorMessageText(), "Required");
    }

    @Test
    public void Register_02_First_Name_And_Last_Name_Max_30_Characters() {
        log.info("Register 02 - Step 01: Set "+invalidLength +" to First Name text box.");
        addEmployeePage.setTextToFirstNameTextbox(invalidLength);

        log.info("Register 02 - Step 02: Set "+invalidLength +" to Last Name text box.");
        addEmployeePage.setTextToLastNameTextbox(invalidLength);

        log.info("Register 02 - Step 03: Set "+invalidLength +" to Id text box.");
        addEmployeePage.setTextToId(invalidLength);

        log.info("Register 02 - Step 04: Verify max length of First Name is 30 characters.");
        verifyEquals(addEmployeePage.getFirstNameCharacterErrorMessageText(), "Should not exceed 29 characters");

        log.info("Register 02 - Step 05: Verify max length of Last Name is 30 characters.");
        verifyEquals(addEmployeePage.getLastNameCharacterErrorMessageText(), "Should not exceed 30 characters");

        log.info("Register 02 - Step 05: Verify max length of ID is 10 characters.");
        verifyEquals(addEmployeePage.getIdErrorMessageText(), "Should not exceed 10 characters");
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
