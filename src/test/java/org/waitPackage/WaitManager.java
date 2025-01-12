package org.waitPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    public WebDriver wd;

    public WaitManager(WebDriver driver){
        this.wd = driver;
    }

    public WebDriverWait wait;
    public Wait fluentWait;

    public void implicitWaitMethod(int timeOutValue){
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOutValue));
    }

    public void explicitWaitMethod(int timeOutValue, By locator)
    {
        wait = new WebDriverWait(wd, Duration.ofSeconds(timeOutValue));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void fluentWaitExample(int totalTimeOutValue, int pollTimeValue, By locator){
        Wait fluentWait = new FluentWait(wd)
                .withTimeout(Duration.ofSeconds(totalTimeOutValue))
                .pollingEvery(Duration.ofSeconds(pollTimeValue))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
