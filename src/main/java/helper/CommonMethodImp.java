package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class CommonMethodImp extends CommonMethods {

    public CommonMethodImp(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void scrollPage(WebDriver driver, int point) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,pont)");
    }

    @Override
    public void javascrpitScroll(By Locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", Locator);
    }

    @Override
    public void javascrpitClick(By Locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", Locator);

    }

    @Override
    public void MouseMoveOver(By Locator) {

    }

    @Override
    public WebElement getElement(By Locator) {

        WebElement element = null;
        try {
            element = driver.findElement(Locator);
            return element;
        } catch (Exception e) {
            System.out.println("Some Exception Occured While Creating element" + Locator.toString());
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public List<WebElement> getElements(By Locator) {
        List<WebElement> element = null;
        try {
            element = driver.findElements(Locator);
            return element;
        } catch (Exception e) {
            System.out.println("Some Exception Occured While Creating element" + Locator.toString());
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public void selectByVisibleText(WebElement element, String param) {
        Select select = new Select(element);
        select.selectByVisibleText(param);
    }

    @Override
    public void moveToElement(WebElement element) {
        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    @Override
    public WebElement getWebElementByParams(String elementname) {
        WebElement element = null;
        try {
            element = driver.findElement(By.xpath(elementname));
            return element;
        } catch (Exception e) {
            System.out.println("Some Exception Occured While Creating element" + element.toString());
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public List<WebElement> getWebElementsByParams(String elementname) {
        List<WebElement> element = null;
        try {
            element = driver.findElements(By.xpath(elementname));
            return element;
        } catch (Exception e) {
            System.out.println("Some Exception Occured While Creating element" + element.toString());
            e.printStackTrace();
        }
        return element;
    }



}
