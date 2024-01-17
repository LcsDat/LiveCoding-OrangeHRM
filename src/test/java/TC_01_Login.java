import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;

public class TC_01_Login extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    HomePageObject homePage;
    HomeSideMenuPageObject homeSideMenu;
    AdminPageObject adminPage;
    PIMPageObject pimPage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void Before_Test(String browser, String url){
        driver = getBrowserDriver(browser, url);

        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.sleepInSecond(5);
    }

    @Test
    public void TC_001_Verify_Login_Successfully(){
        loginPage.setTextToUsernameTextbox("Admin");
        loginPage.setTextToPasswordTextbox("admin123");
        loginPage.clickToLoginButton();

        homePage = PageGenerator.getHomePage(driver);

        Assert.assertEquals(homePage.getDashboardText(),"Dashboard");

//        homeSideMenu = PageGenerator.getHomeSideMenu(driver);
//        homePage.clickToAdminLink();
        adminPage = homePage.openAdminPage();
        adminPage.sleepInSecond(25);

        adminPage.setTextToUsernameTextbox("value");
        adminPage.sleepInSecond(3);
//        adminPage.clickToPimLink();

        pimPage = homePage.openpimPage();
        pimPage.sleepInSecond(10);

        pimPage.setTextToEmployeeNameTextbox("value");
        pimPage.sleepInSecond(3);


    }

    @AfterClass
    public void After_Test(){
        closeBrowser();
    }
}
