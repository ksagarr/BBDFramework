package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public abstract class CommonMethods {

    public WebDriver driver;


    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public abstract String getPageTitle();

    public abstract void scrollPage(WebDriver driver, int point);

    public abstract void javascrpitScroll(By Locator);

    public abstract void javascrpitClick(By Locator);

    public abstract void MouseMoveOver(By Locator);

    public abstract WebElement getElement(By Locator);

    public abstract List<WebElement> getElements(By Locator);

    public abstract void selectByVisibleText(WebElement element , String param);

    public abstract void moveToElement(WebElement element);

    public abstract WebElement getWebElementByParams(String elementname);

    public abstract List<WebElement> getWebElementsByParams(String elementname);



    public <Tpage extends CommonMethodImp> Tpage getInstance(Class<Tpage> pageClass) {

        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


    }


}
