package Tests;

import Pages.sauceDemo;
import Utils.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class sauceDemoLogin extends baseClass {

    @Test
    public void LoginToSD() throws InterruptedException {
        sauceDemo sauceDemo = new sauceDemo(driver);
        sauceDemo.sendText("user-name", "standard_user");
        sauceDemo.sendText("password", "secret_sauce");
        sauceDemo.clickButton("login-button");


        String Title = driver.getTitle();
        String expectedTitle = "Swag Labs";
        Assert.assertEquals(Title, expectedTitle); //1. validation for succesfull login//

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@class='footer']"))); //scroll
        actions.perform();

        sauceDemo.addToCart("add-to-cart-test.allthethings()-t-shirt-(red)");
        sauceDemo.clickButton("add-to-cart-test.allthethings()-t-shirt-(red)");//*[@id="add-to-cart-test.allthethings()-t-shirt-(red)"]
        sauceDemo.clickButton("shopping_cart_container"); //Click on cart to validate if the product is added
        String product1 = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
        Assert.assertEquals(product1, "Test.allTheThings() T-Shirt (Red)");
        //validate the price of product 1
        String expectedPrice1 = "$15.99";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"cart_item\"]/div/div/div")).getText(), expectedPrice1);// Assert the actual and expected price
        sauceDemo.clickButton("continue-shopping");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"app_logo\"]")).getText(), "Swag Labs");//Assert that we are back to continue shopping

        sauceDemo.clickButton("add-to-cart-sauce-labs-backpack");// add new product
        String Product2 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(Product2, "Sauce Labs Backpack"); // Assert that wanted rpoduct is added
        sauceDemo.clickButton("shopping_cart_container");

        Assert.assertEquals(Product2, "Sauce Labs Backpack");
        //Click to checkout
        sauceDemo.clickButton("checkout");
        sauceDemo.sendText("first-name", "Elena");
        sauceDemo.sendText("last-name", "Kara");
        sauceDemo.sendText("postal-code", "1000");
        sauceDemo.clickButton("continue");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='title']")).getText(), "Checkout: Overview");// validation that we are in checkout

        List<WebElement> summaryInfoLabelsXPath = driver.findElements(By.xpath("//div[@class='summary_info_label']"));
        List<WebElement> summaryValueLabelsXPath = driver.findElements(By.xpath("//div[@class='summary_value_label']"));
        List<WebElement> subtotalLabelsXPath = driver.findElements(By.xpath("//div[@class='summary_subtotal_label']"));
        List<WebElement> taxLabelsXPath = driver.findElements(By.xpath("//div[@class='summary_tax_label']"));
        List<WebElement> totalLabelsXPath = driver.findElements(By.xpath("//div[@class='summary_total_label']"));
        Assert.assertEquals("Payment Information:", summaryInfoLabelsXPath.get(0).getText());//da gi smenam obratno
        Assert.assertEquals("Shipping Information:", summaryInfoLabelsXPath.get(1).getText());
        Assert.assertEquals("Price Total", summaryInfoLabelsXPath.get(2).getText());

        Assert.assertEquals("SauceCard #31337", summaryValueLabelsXPath.get(0).getText());
        Assert.assertEquals("Free Pony Express Delivery!", summaryValueLabelsXPath.get(1).getText());

        Assert.assertEquals("Item total: $45.98", subtotalLabelsXPath.get(0).getText());
        Assert.assertEquals("Tax: $3.68", taxLabelsXPath.get(0).getText());
        Assert.assertEquals("Total: $49.66", totalLabelsXPath.get(0).getText());

        sauceDemo.clickButton("finish");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"complete-header\"]")).getText(),"Thank you for your order!");

        sauceDemo.clickButton("back-to-products");// click to return to homepage
        sauceDemo.clickButton("react-burger-menu-btn");// click to find the logout button
        sauceDemo.clickButton("logout_sidebar_link");// click to logout button
        Assert.assertEquals(driver.getTitle(),"Swag Labs");

    }
}





