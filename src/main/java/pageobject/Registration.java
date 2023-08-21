package pageobject;

import helper.CommonMethodImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration extends CommonMethodImp {


    public Registration(WebDriver driver) {
        super(driver);
    }

    private By register = By.xpath("//div[@class=\"header-links\"]/ul/li/a[text()=\"Register\"]");
    private By gender = By.xpath("//div[@id=\"gender\"]/span/input[@id=\"gender-male\"]");

    private By gendertext = By.xpath("//div[@id=\"gender\"]/span/label[@for=\"gender-male\"]");
    private By firstname = By.xpath("//div[@class=\"fieldset\"]/div[@class=\"form-fields\"]/div[2]/input[@id=\"FirstName\"]");
    private By lastname = By.xpath("//div[@class=\"fieldset\"]/div[@class=\"form-fields\"]/div[3]/input[@id=\"LastName\"]");
    private By day = By.xpath("//div[@class=\"fieldset\"]/div[@class=\"form-fields\"]/div[4]/div[@class=\"date-picker-wrapper\"]/select[@name=\"DateOfBirthDay\"]");
    private By month = By.xpath("//div[@class=\"fieldset\"]/div[@class=\"form-fields\"]/div[4]/div[@class=\"date-picker-wrapper\"]/select[@name=\"DateOfBirthMonth\"]");
    private By year = By.xpath("//div[@class=\"fieldset\"]/div[@class=\"form-fields\"]/div[4]/div[@class=\"date-picker-wrapper\"]/select[@name=\"DateOfBirthYear\"]");
    private By email = By.xpath("//div[@class=\"fieldset\"]/div[@class=\"form-fields\"]/div[5]/input[@id=\"Email\"]");
    private By password = By.xpath("//div[@class=\"fieldset\"][4]/div[2]/div/input[@id=\"Password\"]");
    private By comformpassword = By.xpath("//div[@class=\"fieldset\"][4]/div[2]/div[2]/input[@id=\"ConfirmPassword\"]");
    private By registerbutton = By.xpath("//div[@class=\"buttons\"]/button[@id=\"register-button\"]");
    private By massage = By.xpath("//div[@class=\"page registration-result-page\"]/div[2]/div[@class=\"result\"]");
    private By continuebutton = By.xpath("//div[@class=\"page registration-result-page\"]/div[2]/div[@class=\"buttons\"]/a");
    private By titlemassage = By.xpath("//div[@class=\"topic-block-title\"]/h2");

    public WebElement getRegister() {
        return getElement(register);
    }

    public WebElement getGender() {
        return getElement(gender);
    }

    public WebElement getGendertext() {
        return getElement(gendertext);
    }

    public WebElement getFirstname() {
        return getElement(firstname);
    }

    public WebElement getLastname() {
        return getElement(lastname);
    }

    public WebElement getDay() {
        return getElement(day);
    }

    public WebElement getMonth() {
        return getElement(month);
    }

    public WebElement getYear() {
        return getElement(year);
    }

    public WebElement getEmail() {
        return getElement(email);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getComformpassword() {
        return getElement(comformpassword);
    }

    public WebElement getRegisterbutton() {
        return getElement(registerbutton);
    }

    public WebElement getMassage() {
        return getElement(massage);
    }

    public WebElement getContinuebutton() {
        return getElement(continuebutton);
    }

    public WebElement getTitlemassage() {
        return getElement(titlemassage);
    }

    public void clickOnRegisterLink() {
        getRegister().click();
    }

    public void selectGender() {
        getGender().click();
    }
    public void enterfirstnameandlastname(String firstname ,String lastname){
        getFirstname().sendKeys(firstname);
        getLastname().sendKeys(lastname);
    }

    public void selectDOB(String day,String month,String year){
        //select day
        selectByVisibleText(getDay(),day);
        //select month
        selectByVisibleText(getMonth(),month);
        //select year
        selectByVisibleText(getYear(),year);
    }

    public void enterEmail(String email){
        getEmail().sendKeys(email);
    }

    public void enterdPWD(String email,String password){

        getPassword().sendKeys(password);
        getComformpassword().sendKeys(password);
    }

    public  void clickOnRegisterButton(){
        getRegisterbutton().click();
    }

    public void clickOnContinue(){
        getContinuebutton().click();
    }
}
