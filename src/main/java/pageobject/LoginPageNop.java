package pageobject;

import helper.CommonMethodImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageNop extends CommonMethodImp {

    public LoginPageNop(WebDriver driver) {
        super(driver);
    }

    private By loginlink= By.xpath("//div[@class=\"header-links\"]/ul/li/a[@class=\"ico-login\"]");
    private By email=By.xpath("//div[@class=\"inputs\"]/input[@id=\"Email\"]");
    private By password=By.xpath("//div[@class=\"inputs\"]/input[@id=\"Password\"]");
    private By loginbutton=By.xpath("//div[@class=\"buttons\"]/button[@class=\"button-1 login-button\"]");
    private By massage=By.xpath("//div[@class=\"topic-block-title\"]/h2");
    private By myaacount=By.xpath("//div[@class=\"header-links\"]/ul/li/a[@class=\"ico-account\"]");
    private By firstname=By.xpath("//div[@class=\"inputs\"]/input[@id=\"FirstName\"]");
    private By lastname=By.xpath("//div[@class=\"inputs\"]/input[@id=\"LastName\"]");

    public WebElement getMyaacount() {
        return getElement(myaacount);
    }

    public WebElement getFirstname() {
        return getElement(firstname);
    }

    public WebElement getLastname() {
        return getElement(lastname);
    }

    public WebElement getLoginlink() {
        return getElement(loginlink);
    }

    public WebElement getEmail() {
        return getElement(email);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginbutton() {
        return getElement(loginbutton);
    }

    public WebElement getMassage() {
        return getElement(massage);
    }

    public void enterCredentail(String email,String password){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
    }
}
