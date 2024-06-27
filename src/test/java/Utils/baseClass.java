package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class baseClass {
    public static WebDriver driver;


    @BeforeMethod
    public void Setup() throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("121");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
