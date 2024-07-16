import commons.BaseTest;
import commons.GlobalConstant;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AdminPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.UserManagementPageObject;

import java.io.IOException;

public class Admin extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    HomePageObject homePage;
    AdminPageObject adminPage;
    UserManagementPageObject userManagementPage;

    String invalidEmployeeName = "aaabbb";
    String shortUsername = "abcd";
    String longUsername = "abcdeghsdfuiowenvsiowl789564werewr2789dsf";
    String shortPass = "abcd";
    String longPass = "@1Aklsadjfoiwueoifnsaldknsoidfuoiwnlsadlksadufoiwueiorjhlkjadklfj";
    String lowercasePass = "abcdefgh";
    String uppercasePass = "ABCDEFGH";
    String missNumbertPass = "abcdABCD";
    String missSpecialCharPass = "abcd1BCD";
    String unmatchConfirmPass = "#Onimusha000";

    @Parameters({"browser", "url2"})
    @BeforeClass
    public void Before_Test(String browser, String url){
        driver = getBrowserDriver(browser, url);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.loginAdminLevel(GlobalConstant.ADMIN_USERNAME, GlobalConstant.ADMIN_PASSWORD);
        homePage = PageGenerator.getHomePage(driver);
        adminPage = homePage.openAdminPage();
    }

    @Test
    public void Add_Role_01_All_Fields_Is_Required(){
        userManagementPage = adminPage.openUserMamagementPage();
        userManagementPage.clickToAddButton();
        userManagementPage.clickToSaveButton();

        verifyEquals(userManagementPage.getUserRoleErrorMessage(),"Required");
        verifyEquals(userManagementPage.getEmployeeNameErrorMessage(),"Required");
        verifyEquals(userManagementPage.getStatusErrorMessage(),"Required");
        verifyEquals(userManagementPage.getUsernameErrorMessage(),"Required");
        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Required");
        verifyEquals(userManagementPage.getConfirmPasswordErrorMessage(),"Required");
    }
    @Test
    public void Add_Role_02_Must_Be_Employee_To_Add_Role() {
        userManagementPage.selectEmployeeName(invalidEmployeeName);
        userManagementPage.sleepInSecond(3);

        verifyEquals(userManagementPage.getEmployeeNameErrorMessage(),"Invalid");
        userManagementPage.takeScreenshot(driver, "C:\\Users\\hidey\\OneDrive\\Desktop\\New folder", "New photo");
    }
    @Test
    public void Add_Role_03_Username_Must_Be_Unique(){
        userManagementPage.setTexToUsernameTextBox(GlobalConstant.ADMIN_USERNAME);
        userManagementPage.sleepInSecond(2);

        verifyEquals(userManagementPage.getUsernameErrorMessage(), "Already exists");

    }
//    @Test
//    public void Add_Role_04_Username_Must_Be_In_Valid_Length(){
//        userManagementPage.setTexToUsernameTextBox(shortUsername);
//
//        verifyEquals(userManagementPage.getUsernameErrorMessage(),"Should be at least 5 characters");
//
//        userManagementPage.setTexToUsernameTextBox(longUsername);
//
//        verifyEquals(userManagementPage.getUsernameErrorMessage(),"Should not exceed 40 characters");
//    }
//    @Test
//    public void Add_Role_05_Password_Must_Be_Valid(){
//        userManagementPage.setTexToPasswordTextBox(shortPass);
//
//        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Should have at least 8 characters");
//
//        userManagementPage.setTexToPasswordTextBox(lowercasePass);
//
//        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Your password must contain minimum 1 upper-case letter");
//
//        userManagementPage.setTexToPasswordTextBox(uppercasePass);
//
//        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Your password must contain minimum 1 lower-case letter\n");
//
//        userManagementPage.setTexToPasswordTextBox(missNumbertPass);
//
//        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Your password must contain minimum 1 number");
//
//        userManagementPage.setTexToPasswordTextBox(missSpecialCharPass);
//
//        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Your password must contain minimum 1 special character");
//
//        userManagementPage.setTexToPasswordTextBox(longPass);
//
//        verifyEquals(userManagementPage.getPasswordErrorMessage(),"Should not exceed 64 characters");
//
//        userManagementPage.setTexToPasswordTextBox(GlobalConstant.ADMIN_PASSWORD);
//        userManagementPage.setTexToConfirmPasswordTextBox(unmatchConfirmPass);
//
//        verifyEquals(userManagementPage.getConfirmPasswordErrorMessage(),"Passwords do not match");
//    }
//
//
//    @Test
//    public void Add_Role_06_Add_Role_Successfully(){
//        userManagementPage.selectRole("Admin");
//        userManagementPage.selectStatus("Enabled");
//        userManagementPage.selectEmployeeName("Dat81001  Le10420");
//        userManagementPage.setTexToUsernameTextBox("hideyashy01");
//        userManagementPage.setTexToPasswordTextBox(GlobalConstant.ADMIN_PASSWORD);
//        userManagementPage.setTexToConfirmPasswordTextBox(GlobalConstant.ADMIN_PASSWORD);
//        userManagementPage.clickToSaveButton();
//
//    }
//    @AfterClass
//    public void After_Test(){
//
//    }
}
