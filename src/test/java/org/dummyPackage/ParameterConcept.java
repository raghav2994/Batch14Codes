package org.dummyPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterConcept {

    ChromeDriver cd;
    FirefoxDriver fd;

    @Parameters({"browser"})
    @Test
    public void successLoginTest(String browserName){
        System.out.println("Value of Browser is:" + browserName);
        switch (browserName){
            case "Chrome":{
                cd = new ChromeDriver();
                cd.get("https://demo.evershop.io/account/login");
                cd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
                cd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
                cd.quit();
                break;
            }
            case "Firefox":{
                fd = new FirefoxDriver();
                fd.get("https://demo.evershop.io/account/login");
                fd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
                fd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
                fd.quit();
                break;
            }
        }
    }
}
