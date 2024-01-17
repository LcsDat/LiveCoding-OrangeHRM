import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class TC_01_Login extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPage;
    HomePageObject homePage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void Before_Test(String browser, String url){
        driver = getBrowserDriver(browser, url);

        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.sleepInSecond(20);
    }

    @Test
    public void TC_001_Verify_Login_Successfully(){
        loginPage.setTextToUsernameTextbox("Admin");
        loginPage.setTextToPasswordTextbox("admin123");
        loginPage.clickToLoginButton();
        loginPage.sleepInSecond(20);

        homePage = PageGenerator.getHomePage(driver);
        homePage.sleepInSecond(10);

        Assert.assertEquals(homePage.getDashboardText(),"Dashboard");
    }

    @AfterClass
    public void After_Test(){
        closeBrowser();
    }
}
