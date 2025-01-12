package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPageModel {

    private WebDriver driver;

    private String itemSizeXpathLocator = "(//ul[contains(@class, 'variant-option-list')])[1]/li/a[text()='%s']";

    private String itemColourXpathLocator = "(//ul[contains(@class, 'variant-option-list')])[2]/li/a[text()='%s']";

    private By itemNameText = By.xpath("//h1[@class='product-single-name']");

    private By quanityTextBox = By.xpath("//input[@name='qty']");

    private By addToCart = By.xpath("//button[@type='button']");

    public ItemPageModel(WebDriver wd){
        this.driver = wd;
    }

    public String getItemName(){
        return driver.findElement(itemNameText).getText();
    }

    public ItemPageModel fillQuantity(String quantity){
        driver.findElement(quanityTextBox).clear();
        driver.findElement(quanityTextBox).sendKeys(quantity);
        return this;
    }

    public ItemPageModel selectSize(String size){
        String itemSizeLocator = itemSizeXpathLocator.replace("%s",size);
        By itemSizeLink = By.xpath(itemSizeLocator);
        driver.findElement(itemSizeLink).click();
        return this;
    }

    public ItemPageModel selectColour(String colour) throws InterruptedException {
        Thread.sleep(3000);
        String itemColourLocator = itemColourXpathLocator.replace("%s",colour);
        By itemColourLink = By.xpath(itemColourLocator);
        driver.findElement(itemColourLink).click();
        return this;
    }

    public ItemPageModel clickOnAddToCart(){
        driver.findElement(addToCart).click();
        return this;
    }

}
