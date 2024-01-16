import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Template  extends BaseTest {

    @Test
    public void Before_Test(){
        getBrowserDriver("edge", "https://www.youtube.com/");

        closeBrowser();
    }
}
