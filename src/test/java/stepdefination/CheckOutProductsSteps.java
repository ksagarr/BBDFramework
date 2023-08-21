package stepdefination;

import basepackage.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobject.CheckoutProduct;
import util.ContextTest;

import java.util.List;

public class CheckOutProductsSteps extends TestBase {

    public ContextTest contextTest;

    public CheckOutProductsSteps(ContextTest contextTest) {
        super(contextTest);
    }

    @When("User move to tab {string}")
    public void user_move_to_tab(String name) {
        pg.getInstance(CheckoutProduct.class).moveToTab(name);
    }

    @When("User click on {string}")
    public void user_click_on(String tab) {
        pg.getInstance(CheckoutProduct.class).ClickOnOpetion(tab);
    }

    @When("User add notebook <notebook> in addcart \"Lenovo Thinkpad X1 Carbon Laptop\"Examples:")
    public void user_add_notebook_notebook_in_addcart_lenovo_thinkpad_x1_carbon_laptop_examples(io.cucumber.datatable.DataTable dataTable) {
        List<String> products = dataTable.asList();
        products.forEach(s -> System.out.println(s));
        products.forEach(product -> pg.getInstance(CheckoutProduct.class).selectProdcuts(product));

    }

    @When("User click on shopcart")
    public void user_click_on_shopcart() {
        pg.getInstance(CheckoutProduct.class).getShopcart().click();
    }

    @When("User click on terms and checkout button")
    public void user_click_on_terms_and_checkout_button() throws InterruptedException {
        pg.getInstance(CheckoutProduct.class).getTermscheck().click();
        pg.getInstance(CheckoutProduct.class).getCheckout().click();
        Thread.sleep(3000);
    }

    @When("User enter shiping address details like country {string} and state {string} and city {string} and address {string} and pin {string} and phone {string}")
    public void user_enter_shiping_address_details_like_country_and_city_and_address_and_pin_and_phone(String countey, String state ,String city, String address, String pin, String phone) throws InterruptedException {
        Thread.sleep(3000);
        pg.getInstance(CheckoutProduct.class).enterAddress(countey,state, city, address, pin, phone);
    }

    @When("User click on continue button")
    public void user_click_on_continue_button() {
        pg.getInstance(CheckoutProduct.class).getContinuebutton().click();
    }

    @When("User select shiping method and click on continue")
    public void user_select_shiping_method_and_click_on_continue() {
        pg.getInstance(CheckoutProduct.class).getSeccontinuebutton().click();
    }

    @When("User select payment method and click on continue")
    public void user_select_payment_method_and_click_on_continue() {
        pg.getInstance(CheckoutProduct.class).getPaymentContinue().click();
    }

    @When("User click on continue")
    public void user_click_on_continue() {
        pg.getInstance(CheckoutProduct.class).getPaymentIfoContinue().click();
    }

    @When("User validate billing address name {string} and email {string} and phone {string} and city-state-zip {string} and country {string}")
    public void user_validate_billing_address_name_and_email_and_phone_and_city_state_zip_and_country(String name, String email, String phone, String city_state_zip, String country) {
        List<String> billingAdress = pg.getInstance(CheckoutProduct.class).validateBillingAdress();
        List<String> expectedvalue=List.of(name,email,phone,city_state_zip,country);
        for(int i=0;i<expectedvalue.size() && i<billingAdress.size();i++){
            Assert.assertEquals(expectedvalue.get(i),billingAdress.get(i));
        }

    }

    @When("User validate shiping address name {string} and email {string} and phone {string} and city-state-zip {string} and country {string}")
    public void user_validate_shiping_address_name_and_email_and_phone_and_city_state_zip_and_country(String name, String email, String phone, String city_state_zip, String country) {
        List<String> shpingAdress = pg.getInstance(CheckoutProduct.class).validateBillingAdress();
        List<String> expectedvalue=List.of(name,email,phone,city_state_zip,country);
        for(int i=0;i<expectedvalue.size() && i<shpingAdress.size();i++){
            Assert.assertEquals(expectedvalue.get(i),shpingAdress.get(i));
        }
    }

    @When("User valiadte products contains <products>")
    public void user_valiadte_products_contains_products(io.cucumber.datatable.DataTable dataTable) {
        List<String> productname = dataTable.asList();
        List<String> products = pg.getInstance(CheckoutProduct.class).valiadateProducts(productname);
        for (int i = 0; i < productname.size() && i < products.size(); i++) {
            String actual = productname.get(i);
            String expected = products.get(i);
            Assert.assertEquals(expected, actual);
        }
        contextTest.totalprice = pg.getInstance(CheckoutProduct.class).getTotalprice().getText();
    }

    @When("Validate total price {string}")
    public void validate_total_price(String price) {
        Assert.assertEquals(price, contextTest.getTotalprice());
        contextTest.orderMassage = pg.getInstance(CheckoutProduct.class).getOrdermassage().getText();

    }

    @Then("User validate order massage {string}")
    public void user_validate_order_massage(String massage) {
        Assert.assertEquals(massage, contextTest.getOrderMassage());
    }

    @Then("User click on continue and navigate to home page")
    public void user_click_on_continue_and_navigate_to_home_page() {
        pg.getInstance(CheckoutProduct.class).getContiueshopingbutton().click();
    }

}
