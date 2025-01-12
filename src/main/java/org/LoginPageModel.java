package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageModel {

    WebDriver driver;

    private By userNameField = By.xpath("//input[@name='email']");
    private By passwordElement = By.xpath("//input[@name='password']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private String loginPageUrl = "https://demo.evershop.io/account/login";

    public LoginPageModel(WebDriver wd) {
        this.driver = wd;
    }

    public LoginPageModel fillCredentials(String username, String password) {
        driver.findElement(userNameField).
                sendKeys(username);
        driver.findElement(passwordElement).
                sendKeys(password);
        return this;
    }

    public void clickOnSubmit(){
        driver.findElement(submitButton).click();
    }

    public LoginPageModel openingLoginPage(){
        driver.get(loginPageUrl);
        return this;
    }

}
