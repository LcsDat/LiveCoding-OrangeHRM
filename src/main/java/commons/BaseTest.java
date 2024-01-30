package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected final Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
            case EDGE -> driver = new EdgeDriver();
            default -> throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case CHROME -> driver = new ChromeDriver();
            case FIREFOX -> driver = new FirefoxDriver();
            case EDGE -> driver = new EdgeDriver();
            default -> throw new RuntimeException("Browser name is not valid.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstant.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstant.URL);

        return driver;
    }

    protected void closeBrowser() {
        String cmd = "";
        try {
            String osName = GlobalConstant.OS_NAME.toLowerCase();
            String driverInstance = driver.toString().toLowerCase();

            if (driverInstance.contains("chrome")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                } else {
                    cmd = "pkill chromedriver";
                }
            } else if (driverInstance.contains("firefox")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                } else {
                    cmd = "pkill geckodriver";
                }
            } else if (driverInstance.contains("edge")) {
                if (osName.contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                } else {
                    cmd = "pkill msedgedriver";
                }
            }

            if (driver!=null){
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("hello boy");

        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public  void  deleteFiles(){
        deleteFilesInFolder("allure-json");
    }

    public void deleteFilesInFolder(String folderName){
        try {
            String pathFolderName = GlobalConstant.RELATIVE_PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderName);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles!= null) {
                for (File f : listOfFiles) {
                    f.delete();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Verifies that a boolean condition is true and test cases will run till the end.
     *
     * @param condition the boolean condition to verify
     * @return true if the condition is true, false otherwise
     */
    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("PASSED");
        } catch (Throwable e) {
            log.info("FAILED");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    /**
     * Verifies that a boolean condition is false and test cases will run till the end.
     *
     * @param condition the boolean condition to verify
     * @return true if the condition is false, true otherwise
     */
    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("PASSED");
        } catch (Throwable e) {
            log.info("FAILED");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    /**
     * Verifies that two objects are equal test cases will run till the end.
     *
     * @param actual   the actual object
     * @param expected the expected object
     * @return true if the objects are equal, false otherwise
     */
    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("PASSED");
        } catch (Throwable e) {
            log.info("FAILED");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
}
