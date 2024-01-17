package pageObjects;

import commons.BasePage;
import commons.PageGenerator;
import interfaces.HomePageUI;
import interfaces.HomeSideMenuPageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends HomeSideMenuPageObject {


    public HomePageObject(WebDriver driver) {
        super(driver);

    }

    public String getDashboardText() {
        waitForElementVisible(HomePageUI.DASHBOARD_LABEL);
        return getElementText(HomePageUI.DASHBOARD_LABEL);
    }

    public void clickToAdminLink() {
        waitForElementClickable(HomePageUI.ADMIN_LINK);
        clickToElement(HomePageUI.ADMIN_LINK);
    }

}
