package basepackage;

import enums.Browser;
import helper.CommonMethodImp;
import helper.CommonMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefination.HookService;
import util.ContextTest;

import java.time.Duration;

public class TestBase {
    public ContextTest contextTest;

    public TestBase(ContextTest contextTest) {
        this.contextTest = contextTest;
    }

    public static WebDriverWait wait;
    public static CommonMethods pg;

    public static Logger logger;

    public void setUpTest(String brower) {
        if (brower.contains(Browser.CHROME.name())) {
            logger=LogManager.getLogger("TestBase");
            System.out.println(logger);
            logger.info("driver init");
            WebDriverManager.chromedriver().setup();
            contextTest.driver = new ChromeDriver();
        }
        contextTest.driver.manage().window().maximize();
        pg = new CommonMethodImp(contextTest.driver);

    }


}
