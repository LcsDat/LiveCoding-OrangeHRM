package pageObjects;

import interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends HomeSideMenuPageObject {


    public HomePageObject(WebDriver driver) {
        super(driver);

    }

    public String getDashboardText() {
        waitForElementVisible(HomePageUI.DASHBOARD_LABEL);
        return getElementText(HomePageUI.DASHBOARD_LABEL);
    }

}
