package org;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.waitPackage.WaitManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstSeleniumCode {

    @Test
    public void successLogin(){

//        ChromeOptions c = new ChromeOptions();
//        WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.1.6:4444"),c);

        ChromeDriver driver = new ChromeDriver();
//        WaitManager wm = new WaitManager(driver);


        //Step 1 - Hit the URL of Login Page
        driver.get("https://demo.evershop.io/account/login");
        By submitLocator = By.xpath("//button[@type='submit']");
        //Implicit Wait
//          wm.implicitWaitMethod(10);
//          wm.explicitWaitMethod(10, submitLocator);
//          wm.fluentWaitExample(10,5,submitLocator);


//        //Step 2- Enter the email
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");

        //Step 3- Click On Sign In Button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Validate homePage icon

        //Step 4 - Close the browser
        driver.quit();



    }
    public static void invokeSeleniumGridCode() throws MalformedURLException
    {
        ChromeOptions c = new ChromeOptions();
        WebDriver wd = new RemoteWebDriver(new URL(" http://192.168.1.6:4444"),c);

        wd.get("https://demo.evershop.io/account/login");

       // wd.quit();

    }
    public void regularDriverCode(){
        ChromeDriver cd = new ChromeDriver();
        cd.get("https://demo.evershop.io/account/login");
        cd.quit();

        FirefoxDriver f = new FirefoxDriver();
        f.get("https://demo.evershop.io/account/login");
        f.quit();
    }
}
