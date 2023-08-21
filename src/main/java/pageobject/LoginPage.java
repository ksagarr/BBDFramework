package pageobject;

import helper.CommonMethodImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonMethodImp {

    private By username = By.xpath("//div[@id=\"login_button_container\"]/div/form/input[@id=\"user-name\"]");
    private By password = By.xpath("//div[@id=\"login_button_container\"]/div/form/input[@id=\"password\"]");
    private By loginButton = By.xpath("//div[@id=\"login_button_container\"]/div/form/input[@id=\"login-button\"]");

    private By title = By.xpath("//div[@class=\"header_secondary_container\"]/div[3]/div[text()=\"Products\"]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsername() {
        return getElement(username);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public WebElement getTitle() {
        return getElement(title);
    }


    public void doLogin(String username, String password) {
        getUsername().sendKeys(username);
        getPassword().sendKeys(password);
    }

    public void clickLoginButton(){
        getLoginButton().click();
    }

    public String validateMessage(){
       return getTitle().getText();
    }

}
