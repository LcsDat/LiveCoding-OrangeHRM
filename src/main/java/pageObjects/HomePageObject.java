package pageObjects;

import commons.BasePage;
import interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    public String getDashboardText() {
        waitForElementVisible(HomePageUI.DASHBOARD_LABEL);
        return getElementText(HomePageUI.DASHBOARD_LABEL);
    }
}
