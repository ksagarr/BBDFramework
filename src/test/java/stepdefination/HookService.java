package stepdefination;

import basepackage.TestBase;
import enums.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.ContextTest;

public class HookService {

    ContextTest contextTest;

    TestBase testBase;


    @Before
    public void initializeTest() {
        contextTest=new ContextTest();
        testBase = new TestBase(contextTest);
        testBase.setUpTest(Browser.CHROME.name());
    }

    @After(order = 0)
    public void browserQuit(){
        contextTest.driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario sc){
        if(sc.isFailed()){
            String screenShotName=sc.getName().replaceAll(" ","_");
            byte[] sourcePath=((TakesScreenshot)contextTest.driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath,"image/png",screenShotName);
        }
    }
}
