import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    //this class covers test case "Home Page display in different browsers" (TC_1)

    public HomePageTest (){super();}

    //initialization of setup from TestBase class
    @BeforeMethod
    public void setUp(){
        initialization();
    }

    @AfterMethod
    public void testDone() {
        driver.close();
        driver.quit();
    }

    //browser can be switched in config.properties using 4 variables: chrome, opera, firefox, msedge
    //i.e. browser = chrome
    @Test
    public void HomePageTitle(){
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctHomePageTitle"));
    }

}
