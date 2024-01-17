package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageGenerator extends BasePage{


    public PageGenerator(WebDriver driver) {
        super(driver);
    }

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

    public static HomeSideMenuPageObject getHomeSideMenu(WebDriver driver){
        return new HomeSideMenuPageObject(driver);
    }


}
