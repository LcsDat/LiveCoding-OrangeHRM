package pageObjects;

import commons.BasePage;
import commons.PageGenerator;
import interfaces.AdminHeaderPageUI;
import org.openqa.selenium.WebDriver;

public class AdminHeaderPageObject extends BasePage {
    WebDriver driver;
    public AdminHeaderPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserManagementPageObject openUserMamagementPage(){
        waitForElementClickable(AdminHeaderPageUI.USERMAGEMENT_LINK);
        clickToElement(AdminHeaderPageUI.USERMAGEMENT_LINK);

        return PageGenerator.getUserMagementPage(driver);
    }
}
