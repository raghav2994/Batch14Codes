package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.HomePageModel;
import org.ItemPageModel;
import org.LoginPageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class E2EStepDef {
    private WebDriver wd;

    LoginPageModel login;
    HomePageModel home;
    ItemPageModel item;

    @Before
    public void setUpWebDriver() throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        wd = new RemoteWebDriver(new URL("http://192.168.1.11:4444"), chromeOptions);
        login = new LoginPageModel(wd);
        home = new HomePageModel(wd);
        item = new ItemPageModel(wd);
    }

    @After
    public void tearDownWebDriver(){
        if(wd!= null){
            wd.quit();
        }
    }

    @Given("User is already loggedIn with credentials as {string} and {string}")
    public void userLogin(String UN, String PW){
        login.openingLoginPage().
                fillCredentials(UN, PW).
                clickOnSubmit();
    }

    @Given("User click on Item {string}")
    public void clickItem(String itemName) throws InterruptedException {
        Thread.sleep(5000);
        home.clickItem(itemName);
    }

    @When("User selects the item options size as {string} and color as {string}")
    public void selectItemOption(String size, String colour) throws InterruptedException {
        Thread.sleep(5000);
        item.fillQuantity("2")
                .selectSize(size)
                .selectColour(colour);
    }

    @When("User clicks on AddToCart")
    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(5000);
        item.clickOnAddToCart();
    }

}
