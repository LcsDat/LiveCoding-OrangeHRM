package pageObjects;

import interfaces.HomePageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends HomeSideMenuPageObject {


    public HomePageObject(WebDriver driver) {
        super(driver);

    }

    @Step("Get Dashboard text")
    public String getDashboardText() {
        waitForElementVisible(HomePageUI.DASHBOARD_LABEL);
        return getElementText(HomePageUI.DASHBOARD_LABEL);
    }

}
