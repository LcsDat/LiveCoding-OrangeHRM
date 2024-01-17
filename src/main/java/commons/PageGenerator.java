package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.AdminPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PIMPageObject;

public class PageGenerator {


    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static AdminPageObject getAdminPage(WebDriver driver){
        return new AdminPageObject(driver);
    }

    public static PIMPageObject getpimPage(WebDriver driver){
        return new PIMPageObject(driver);
    }


}
