package pageobject;

import helper.CommonMethodImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseProduct extends CommonMethodImp {

    private By cart = By.xpath("//div[@id=\"shopping_cart_container\"]");
    private By checkout = By.xpath("//div[@class=\"cart_footer\"]/a[text()=\"CHECKOUT\"]");
    private By productname = By.xpath("//div[@class=\"cart_item_label\"]/a/div[@class=\"inventory_item_name\"]");
    private By firstname = By.xpath("//div[@class=\"checkout_info\"]/input[@data-test=\"firstName\"]");
    private By lastname = By.xpath("//div[@class=\"checkout_info\"]/input[@data-test=\"lastName\"]");
    private By postalcode = By.xpath("//div[@class=\"checkout_info\"]/input[@data-test=\"postalCode\"]");
    private By continuebutton = By.xpath("//div[@class=\"checkout_buttons\"]/input[@value=\"CONTINUE\"]");
    private By totalprice = By.xpath("//div[@class=\"summary_total_label\"]");
    private By finish = By.xpath("//div[@class=\"cart_footer\"]/a[text()=\"FINISH\"]");
    private By massage = By.xpath("//div[@id=\"checkout_complete_container\"]/h2");


    public PurchaseProduct(WebDriver driver) {
        super(driver);
    }

    public WebElement getCart() {
        return getElement(cart);
    }

    public WebElement getCheckout() {
        return getElement(checkout);
    }

    public WebElement getProductname() {
        return getElement(productname);
    }

    public WebElement getFirstname() {
        return getElement(firstname);
    }

    public WebElement getLastname() {
        return getElement(lastname);
    }

    public WebElement getPostalcode() {
        return getElement(postalcode);
    }

    public WebElement getContinuebutton() {
        return getElement(continuebutton);
    }

    public WebElement getTotalprice() {
        return getElement(totalprice);
    }

    public WebElement getFinish() {
        return getElement(finish);
    }

    public WebElement getMassage() {
        return getElement(massage);
    }

    public void selectProduct(String product) {
        String productname = "//div[@class=\"inventory_item\"]/div[2]/a/div[text()='" + product + "']/../../ following-sibling::div/button[text()=\"ADD TO CART\"]";
        By element = By.xpath(productname);
        WebElement select = getElement(element);
        select.click();
    }

    public void navigateCart() {
        getCart().click();
    }

    public void clickCheckOut() {
        getCheckout().click();
    }

    public String getProductName() {
        return getProductname().getText();
    }

    public void enterAddress(String fisrtname,String lastname,String postcode){
        getFirstname().sendKeys(fisrtname);
        getLastname().sendKeys(lastname);
        getPostalcode().sendKeys(postcode);
    }

    public void clickContinues(){
        getContinuebutton().click();
    }

    public String totalPrice(){
        return getTotalprice().getText();
    }

    public void clickFinish(){
        getFinish().click();
    }
    public String getOrderMassage(){
        return getMassage().getText();
    }
}
