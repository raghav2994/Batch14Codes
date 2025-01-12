package org.demoEverTest;

import org.HomePageModel;
import org.ItemPageModel;
import org.LoginPageModel;
import org.dataDrivenTesting.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DemoEverTest {

    ChromeOptions cd;
    WebDriver wd;

    @BeforeMethod
    public void beforeMethodForDemoEver() throws MalformedURLException {

        cd = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://192.168.1.4:4444"), cd);

    }

//    @Test
//    public void addToCartTest() throws InterruptedException {
//        LoginPageModel lom = new LoginPageModel(wd);
//        HomePageModel hom = new HomePageModel(wd);
//        ItemPageModel iom = new ItemPageModel(wd);
//        lom.openingLoginPage()
//                .fillCredentials("akhiljda@gmail.com", "Password")
//                .clickOnSubmit();
//        hom.clickItem("Nike react infinity run flyknit");
//        Assert.assertEquals(iom.getItemName(), "Nike React Infinity Run Flyknit");
//        Thread.sleep(5000);
//        iom.selectSize("M")
//                .selectColour("Green")
//                .fillQuantity("5")
//                .clickOnAddToCart();
//
//    }

    @DataProvider(name = "LoginData")
    public Object[][] generateData() throws IOException {
        return ExcelManager.getData();
    }

    @Test(dataProvider = "LoginData")
    public void successLogin(String UN, String PW) throws InterruptedException {
        LoginPageModel lom = new LoginPageModel(wd);
        HomePageModel hom = new HomePageModel(wd);
        ItemPageModel iom = new ItemPageModel(wd);
        lom.openingLoginPage()
                .fillCredentials(UN, PW)
                .clickOnSubmit();

//    @AfterClass
//    public void tearDownBrowser(){
//        wd.quit();
//    }
    }

}