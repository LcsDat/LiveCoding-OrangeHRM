package interfaces;

import org.openqa.selenium.WebDriver;
import pageObjects.HomeSideMenuPageObject;

public class AdminPageUI  {
    public static final String USERNAME_TEXTBOX ="xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
    public static final String PIM_LINK ="xpath=//span[text()='PIM']//ancestor::a";
}
