package pageobject;

import helper.CommonMethodImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckoutProduct extends CommonMethodImp {

    public CheckoutProduct(WebDriver driver) {
        super(driver);
    }

    private By shopcart = By.xpath("//div[@id=\"bar-notification\"]/div/p/a");
    private By totalprice = By.xpath("//div[@class=\"total-info\"]/table/tbody/tr[4]/td[2]/span/strong");
    private By termscheck = By.xpath("//div[@class=\"terms-of-service\"]/input[@name=\"termsofservice\"]");
    private By checkout = By.xpath("//div[@class=\"checkout-buttons\"]/button[@value=\"checkout\"]");
    private By state = By.xpath("//div[@class=\"enter-address\"]/div/div[6]/select[@id=\"BillingNewAddress_StateProvinceId\"]");
    private By country = By.xpath("//div[@class=\"enter-address\"]/div/div[5]/select[@id=\"BillingNewAddress_CountryId\"]");
    private By city = By.xpath("//div[@class=\"enter-address\"]/div/div[7]/input[@id=\"BillingNewAddress_City\"]");
    private By address = By.xpath("//div[@class=\"enter-address\"]/div/div[8]/input[@id=\"BillingNewAddress_Address1\"]");
    private By zipcode = By.xpath("//div[@class=\"enter-address\"]/div/div[10]/input[@id=\"BillingNewAddress_ZipPostalCode\"]");
    private By phone = By.xpath("//div[@class=\"enter-address\"]/div/div[11]/input[@id=\"BillingNewAddress_PhoneNumber\"]");
    private By continuebutton = By.xpath("//div[@id=\"billing-buttons-container\"]/button[@class=\"button-1 new-address-next-step-button\"]");

    private By paymentContinue= By.xpath("//div[@id=\"payment-method-buttons-container\"]/button[@onclick=\"PaymentMethod.save()\"]");
    private By paymentIfoContinue= By.xpath("//div[@id=\"payment-info-buttons-container\"]/button[@onclick=\"PaymentInfo.save()\"]");
    private By seccontinuebutton = By.xpath("//div[@id=\"checkout-step-shipping-method\"]/form/div[2]/button[@class=\"button-1 shipping-method-next-step-button\"]");
    private By billingaddress = By.xpath("//div[@class=\"billing-info\"]/ul/li[@class=\"name\"]");
    private By shipingaddress = By.xpath("//div[@class=\"shipping-info\"]/ul/li[@class=\"name\"]");
    private By validproduct = By.xpath("//div[@class=\"table-wrapper\"]/table/tbody/tr");
    private By conformbutton = By.xpath("//div[@id=\"confirm-order-buttons-container\"]/button[@class=\"button-1 confirm-order-next-step-button\"]");
    private By ordermassage = By.xpath("//div[@class=\"page-body checkout-data\"]/div/div/strong");
    private By contiueshopingbutton = By.xpath("//div[@class=\"buttons\"]/button");

    public WebElement getCity() {
        return getElement(city);
    }

    public WebElement getPaymentIfoContinue() {
        return getElement(paymentIfoContinue);
    }

    public List<WebElement> getValidproduct() {
        return getElements(validproduct);
    }

    public WebElement getState() {
        return getElement(state);
    }
    public WebElement getPaymentContinue() {
        return getElement(paymentContinue);
    }
    public WebElement getAddress() {
        return getElement(address);
    }

    public WebElement getZipcode() {
        return getElement(zipcode);
    }

    public WebElement getPhone() {
        return getElement(phone);
    }

    public WebElement getContinuebutton() {
        return getElement(continuebutton);
    }

    public WebElement getSeccontinuebutton() {
        return getElement(seccontinuebutton);
    }

    public WebElement getConformbutton() {
        return getElement(conformbutton);
    }

    public WebElement getOrdermassage() {
        return getElement(ordermassage);
    }

    public WebElement getContiueshopingbutton() {
        return getElement(contiueshopingbutton);
    }

    public WebElement getShopcart() {
        return getElement(shopcart);
    }

    public WebElement getTotalprice() {
        return getElement(totalprice);
    }

    public WebElement getCountry() {
        return getElement(country);
    }

    public WebElement getTermscheck() {
        return getElement(termscheck);
    }

    public WebElement getCheckout() {
        return getElement(checkout);
    }

    public void moveToTab(String headlinks) {
        WebElement element = getWebElementByParams("//div[@class=\"header-menu\"]/ul[@class=\"top-menu notmobile\"]/li/a[text()='"+headlinks+"']");
        moveToElement(element);
    }

    public void ClickOnOpetion(String options)
    {
        WebElement element=getWebElementByParams("//div[@class=\"header-menu\"]/ul[@class=\"top-menu notmobile\"]/li/ul[@class=\"sublist first-level\"]/li/a[text()='"+options+"']");
        element.click();
    }

    public void selectProdcuts(String productname)
    {
        List<WebElement> element=getWebElementsByParams("//div[@class=\"item-grid\"]/div/div/div[2]/h2/a[text()='"+productname+"']/../../div[3]/div[@class=\"buttons\"]/button[text()=\"Add to cart\"]");
        element.forEach(elements ->{
            try {
                Thread.sleep(3000);
                elements.click();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void enterAddress(String country ,String state,String city ,String address ,String pin ,String phone )
    {
        selectByVisibleText(getCountry(),country);
        selectByVisibleText(getState(),state);
        getCity().sendKeys(city);
        getAddress().sendKeys(address);
        getZipcode().sendKeys(pin);
        getPhone().sendKeys(phone);
    }

    public List<String> validateBillingAdress()
    {
        List<String> args= Arrays.asList("name","email","phone","city-state-zip","country");
        List<String> billingAddress= new ArrayList<>();
        List<WebElement> elements =args.stream().map(element->getWebElementByParams("//div[@class=\"billing-info\"]/ul/li[@class='"+element+"']")).collect(Collectors.toList());


        billingAddress=elements.stream().map(atr->atr.getText()).collect(Collectors.toList());
        System.out.println(billingAddress.get(3));
        return billingAddress;
        /*WebElement userfullname=getWebElementByParams("//div[@class=\"billing-info\"]/ul/li[@class='"+name+"']");
        WebElement useremail=getWebElementByParams("//div[@class=\"billing-info\"]/ul/li[@class='"+email+"']");
        WebElement userphone=getWebElementByParams("//div[@class=\"billing-info\"]/ul/li[@class='"+phone+"']");
        WebElement usercityzip=getWebElementByParams("//div[@class=\"billing-info\"]/ul/li[@class='"+city_state_zip+"']");
        WebElement usercounrty=getWebElementByParams("//div[@class=\"billing-info\"]/ul/li[@class='"+country+"']");*/

    }

    public List<String> validateShippingAddress(String name,String email, String phone ,String city_state_zip,String country){
        List<String> args= Arrays.asList("name","email","phone","city-state-zip","country");
        List<String> shipingAddress= new ArrayList<>();
        List<WebElement> elements =args.stream().map(element->getWebElementByParams("//div[@class=\"shipping-info\"]/ul/li[@class='"+element+"']")).collect(Collectors.toList());


        shipingAddress=elements.stream().map(atr->atr.getText()).collect(Collectors.toList());
        System.out.println(shipingAddress.get(3));
        return shipingAddress;
    }

    public List<String> valiadateProducts(List<String> product)
    {   
        List<String> addProducts = null;
        for(int i=1;i<product.size();i++){
            WebElement element=driver.findElement(By.xpath("//div[@class=\"table-wrapper\"]/table/tbody/tr["+i+"]/td[3]/a"));
            addProducts=new ArrayList<>();
            addProducts.add(element.getText());
        }
        return addProducts;
    }
}
