package stepdefination;

import basepackage.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.PurchaseProduct;
import util.ContextTest;

public class PurchaseProductStep extends TestBase {

    String actualProductName;
    String actualTotalPrice;

    String actualOrderMessage;

    public PurchaseProductStep(ContextTest contextTest) {
        super(contextTest);
    }

    @When("user selected the product {string}")
    public void user_selected_the_product(String product) {
       pg.getInstance(PurchaseProduct.class).selectProduct(product);

    }
    @When("user navigated to cart page")
    public void user_navigated_to_cart_page() {
      pg.getInstance(PurchaseProduct.class).navigateCart();
    }
    @When("user clicked on checkout page and navogated to checkout page")
    public void user_clicked_on_checkout_page_and_navogated_to_checkout_page() {
        actualProductName  = pg.getInstance(PurchaseProduct.class).getProductName();
        pg.getInstance(PurchaseProduct.class).clickCheckOut();
    }
    @When("validate the added product {string}")
    public void validate_the_added_product(String expectedProduct) {
        Assert.assertEquals(actualProductName,expectedProduct);
    }
    @When("user entered firstname {string} lastname {string} and Zip code {string}")
    public void user_entered_firstname_lastname_and_zip_code(String firstname, String lastname, String postalcode) {
        pg.getInstance(PurchaseProduct.class).enterAddress(firstname,lastname,postalcode);
    }
    @When("user clicked on continue page")
    public void user_clicked_on_continue_page() {
       pg.getInstance(PurchaseProduct.class).clickContinues();
    }
    @Then("user navigated to payment page")
    public void user_navigated_to_payment_page() {
        String total=pg.getInstance(PurchaseProduct.class).totalPrice();
        actualTotalPrice=total.split(" ")[1];
    }
    @Then("validate the final price of product {string}")
    public void validate_the_final_price_of_product(String expectedTotalPrice) {
      Assert.assertEquals(actualTotalPrice,expectedTotalPrice);
    }
    @Then("user clicked on finish button")
    public void user_clicked_on_finish_button() {
        pg.getInstance(PurchaseProduct.class).clickFinish();
        actualOrderMessage=pg.getInstance(PurchaseProduct.class).getOrderMassage();
    }
    @Then("validate with completed message {string}")
    public void validate_with_completed_message(String expectedOrderMessage) {
        Assert.assertEquals(actualOrderMessage,expectedOrderMessage);
    }

}
