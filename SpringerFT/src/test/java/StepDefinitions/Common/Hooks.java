package StepDefinitions.Common;

import Configurations.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Hooks {
    public static volatile WebDriver driver;

    @Before()
    public void testSetup() throws Exception {
        Driver.clearInstance();
        driver = Driver.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After()
    public void testShutdown() throws Exception {
        driver.quit();
    }

}
