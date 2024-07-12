import commons.BaseTest;
import commons.PageGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.AdminPageObject;

import java.util.Scanner;

public class TC_Template  extends BaseTest {
    WebDriver driver;

    @Parameters({"browser", "url2"})
    @BeforeClass
    public void Before_Test(String browser, String url){
        driver = getBrowserDriver(browser, url);
    }

    @Test
    public void TC_01(){

    }
    @Test
    public void TC_02(){

    }
    @Test
    public void TC_03(){

    }
    @Test
    public void TC_04(){

    }

    @AfterClass
    public void After_Test(){

    }
}
