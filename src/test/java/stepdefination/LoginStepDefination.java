package stepdefination;

import basepackage.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import util.ContextTest;

import java.time.Duration;

public class LoginStepDefination extends TestBase {
    ContextTest contextTest;

    public LoginStepDefination(ContextTest contextTest) {
        super(contextTest);
        this.contextTest = contextTest;
    }

    String actualMessage;
    @Given("user is on home page")
    public void user_is_on_home_page() {
        contextTest.driver.get("https://www.saucedemo.com/v1/");
        contextTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("user entered username {string} and password {string}")
    public void user_entered_username_and_password(String username, String password) {
        System.out.println(username);
       pg.getInstance(LoginPage.class).doLogin(username,password);
    }
    @When("user clicked on login button")
    public void user_clicked_on_login_button() {
           pg.getInstance(LoginPage.class).clickLoginButton();
    }
    @Then("user navigated to homepage")
    public void user_navigated_to_homepage() {
        actualMessage=pg.getInstance(LoginPage.class).validateMessage();

    }
    @Then("validate the message {string}")
    public void validate_the_message(String expectedMassage) {
        Assert.assertEquals(actualMessage,expectedMassage);
    }

}
