package stepdefination;

import basepackage.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.LoginPageNop;
import util.ContextTest;

import java.time.Duration;

public class LoginPageNopSteps extends TestBase {
    private ContextTest contextTest;

    public LoginPageNopSteps(ContextTest contextTest) {
        super(contextTest);
    }

    String actualTitle;
    String actualFirstName;
    String actualLasttName;
    String actualEmail;

    @Given("User launch the url")
    public void user_launch_the_url() {
        ContextTest.driver.get("https://demo.nopcommerce.com/");
        contextTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("Click on login link")
    public void click_on_login_link() throws InterruptedException {
        pg.getInstance(LoginPageNop.class).getLoginlink().click();
    }

    @When("Enter email {string} and password {string}")
    public void enter_email_and_password(String email, String password) throws InterruptedException {
        pg.getInstance(LoginPageNop.class).enterCredentail(email, password);

    }

    @When("Click on login button")
    public void click_on_login_button() throws InterruptedException {
        pg.getInstance(LoginPageNop.class).getLoginbutton().click();
        Thread.sleep(5000);
        actualTitle = pg.getInstance(LoginPageNop.class).getMassage().getText();
    }

    @When("Validate title massage {string}")
    public void validate_title_massage(String expectedTitle) {
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("Click on myaacount link")
    public void click_on_myaacount_link() {
        pg.getInstance(LoginPageNop.class).getMyaacount().click();
    }

    @When("User navigate to myaccount page")
    public void user_navigate_to_myaccount_page() {
        actualFirstName = pg.getInstance(LoginPageNop.class).getFirstname().getAttribute("value");
        actualLasttName = pg.getInstance(LoginPageNop.class).getLastname().getAttribute("value");
        actualEmail = pg.getInstance(LoginPageNop.class).getEmail().getAttribute("value");
    }

    @Then("validate firstname {string} and lastname {string}")
    public void validate_firstname_and_lastname(String firstname, String lastname) {
        Assert.assertEquals(firstname, actualFirstName);
        Assert.assertEquals(lastname, actualLasttName);
    }

    @Then("validate email {string}")
    public void validate_email(String email) {
        Assert.assertEquals(email, actualEmail);
    }


}
