import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC_Template  extends BaseTest {

    @Test
    public void Before_Test(){
        WebDriver driver = getBrowserDriver("edge", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("aaa");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("bbb");
    }
}
