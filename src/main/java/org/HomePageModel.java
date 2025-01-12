package org;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageModel {

    WebDriver driver;

//    private By item = By.xpath("//div[@class='listing-tem']//a/span[text()='dummyString']");

    private String itemText = "//div[@class='listing-tem']//a/span[text()='%s']";

    public HomePageModel(WebDriver wd){
        this.driver = wd;
    }

    public void clickItem(String itemName) throws InterruptedException {
        Thread.sleep(5000);
        String prefferedItemName = itemText.replace("%s", itemName);
        WebElement itemElement = driver.findElement(By.xpath(prefferedItemName));
       itemElement.click();

    }
}
