package Pages;

import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sauceDemo extends baseClass {
    public sauceDemo(WebDriver driver) {
        this.driver = driver; //konstruktor
    }

    public void sendText(String id, String text) throws InterruptedException {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void clickButton(String id) throws InterruptedException {
        driver.findElement(By.id(id)).click();

    }

    public void addToCart(String id) throws InterruptedException {
        driver.findElement(By.id(id));
    }
}





