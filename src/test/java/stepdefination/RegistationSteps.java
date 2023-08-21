package stepdefination;

import basepackage.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.Registration;
import util.ContextTest;

public class RegistationSteps extends TestBase {
    ContextTest contextTest;
    String actualgender;
    String actulRegisterMassage;
    String actualHomeTitle;
    public RegistationSteps(ContextTest contextTest) {
        super(contextTest);
    }


    @Given("user is on homepage")
    public void user_is_on_homepage() {
       contextTest.driver.get("https://demo.nopcommerce.com/");

    }
    @When("user click on register link")
    public void user_click_on_register_link() {
        pg.getInstance(Registration.class).clickOnRegisterLink();

    }
    @When("user select gender")
    public void user_select_gender() {
        pg.getInstance(Registration.class).selectGender();
        actualgender=pg.getInstance(Registration.class).getGendertext().getText();
    }
    @When("validate gander is {string}")
    public void validate_gander_is(String expectedgender) {
        Assert.assertEquals(expectedgender,actualgender);
    }
    @When("user enter firstname {string} and lastname {string}")
    public void user_enter_firstname_and_lastname(String firstname, String lastname) {
       pg.getInstance(Registration.class).enterfirstnameandlastname(firstname,lastname);
    }
    @When("user select date of birth day {string} and Month {string} and Year {string}")
    public void user_select_date_of_birth_day_and_month_and_year(String day, String month, String year) {
        pg.getInstance(Registration.class).selectDOB(day,month,year);
    }

    @When("user enter email {string}")
    public void user_enter_email(String eamil) {
        pg.getInstance(Registration.class).enterEmail(eamil);
    }
    @When("user enter password {string} and comformpassword {string}")
    public void user_enter_password_and_comformpassword(String password, String cpassword) {
        pg.getInstance(Registration.class).enterdPWD(password,cpassword);
    }
    @When("User click on register button")
    public void user_click_on_register_button() {
        pg.getInstance(Registration.class).clickOnRegisterButton();
    }
    @Then("user navigate to register resutt page")
    public void user_navigate_to_register_resutt_page() {
        actulRegisterMassage= pg.getInstance(Registration.class).getMassage().getText();
    }
    @Then("validate the massage {string}")
    public void validate_the_massage(String expectedRegisterMassage) {
      Assert.assertEquals(expectedRegisterMassage,actulRegisterMassage);
    }
    @Then("user click on continue button")
    public void user_click_on_continue_button() {
        pg.getInstance(Registration.class).clickOnContinue();
    }

    @Then("user navigate to homepage")
    public void user_navigate_to_homepage() {
       actualHomeTitle= pg.getInstance(Registration.class).getTitlemassage().getText();
    }
    @Then("validate homepage the massage {string}")
    public void validate_homepage_the_massage(String expectedHomeTitle) {
       Assert.assertEquals(expectedHomeTitle,actualHomeTitle);
        System.out.println("assert succefully");
    }

}
