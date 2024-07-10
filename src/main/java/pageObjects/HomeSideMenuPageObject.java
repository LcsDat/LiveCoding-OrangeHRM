package pageObjects;

import commons.BasePage;
import commons.PageGenerator;
import interfaces.HomeSideMenuPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HomeSideMenuPageObject extends BasePage {
    WebDriver driver;

    public HomeSideMenuPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Open Admin Page")
    public AdminPageObject openAdminPage() {
        waitForElementVisible(HomeSideMenuPageUI.ADMIN_LINK);
        clickToElement(HomeSideMenuPageUI.ADMIN_LINK);

        return new AdminPageObject(driver);
    }

    @Step("Open PIM Page")
    public PIMPageObject openpimPage() {
        waitForElementVisible(HomeSideMenuPageUI.PIM_LINK);
        clickToElement(HomeSideMenuPageUI.PIM_LINK);

        return PageGenerator.getPIMPage(driver);
    }
}
