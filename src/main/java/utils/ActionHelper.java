package utils;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalConstant;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ActionHelper extends BasePage{
    WebDriver driver;

    public ActionHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static void takeScreenshot(String screenshotName) {
        try {
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(GlobalConstant.SCREENSHOT_PATH + File.separator + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
