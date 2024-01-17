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
//        loginPage.sleepInSecond(5);
    }

    @Test
    public void TC_001_Verify_Login_Successfully(){
        loginPage.setTextToUsernameTextbox("hideyashy");
        loginPage.setTextToPasswordTextbox("#Onimusha00");
        loginPage.clickToLoginButton();
//        loginPage.sleepInSecond(5);

        homePage = PageGenerator.getHomePage(driver);
//        homePage.sleepInSecond(5);

        Assert.assertEquals(homePage.getDashboardText(),"Dashboard");

        adminPage = homeSideMenu.openAdminPage();

        adminPage.setTextToUsernameTextbox("value");
        adminPage.sleepInSecond(3);
        pimPage = homeSideMenu.openpimPage();

        pimPage.setTextToEmployeeNameTextbox("value");
        pimPage.sleepInSecond(3);


    }

    @AfterClass
    public void After_Test(){
        closeBrowser();
    }
}
