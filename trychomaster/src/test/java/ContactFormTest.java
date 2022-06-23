import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContactFormTest extends TestBase {

    //this class covers Test Case "Contact Form" (TC_6)
    public ContactFormTest (){super();}

    //initialization of setup from TestBase class
    @BeforeClass
    public void setUp () {initialization();}

    @AfterClass
    public void testDone () {
        driver.close();
        driver.quit();
    }


    //getting to contact form
    @Test (priority = 1)
    public void Kontakt () {
        WebElement KontaktButton = driver.findElement(By.xpath("//*[contains(text(), 'Kontakt')][@class='footer-link']"));
        KontaktButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctKontaktPageTitle"));


    }
    //filling in Name cell
    @Test (priority = 2)
    public void NameSurname () {
        WebElement NameSurnameInput = driver.findElement(By.xpath("//input[@name='name']"));
        NameSurnameInput.clear();
        NameSurnameInput.sendKeys("Krystian Kuhn");

    }
    //filling in Mail cell
    @Test (priority = 3)
    public void Email () {
        WebElement EmailInput = driver.findElement(By.xpath("//input[@name='Email']"));
        EmailInput.clear();
        EmailInput.sendKeys("krystiankuhn90@gmail.com");
    }
    //filling in Message cell
    @Test (priority = 4)
    public void Message () throws InterruptedException {
        WebElement MessageInput = driver.findElement(By.xpath("//textarea[@name='Message']"));
        MessageInput.clear();
        MessageInput.sendKeys("Test");

        Thread.sleep(2000);
    }
    //confirming and checking if proper info is displayed
    @Test (priority = 5)
    public void Confirmation () {
        WebElement SendConfirmationButton = driver.findElement(By.xpath("//input[@type='submit']"));
        SendConfirmationButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success-message w-form-done']")));
        WebElement ConfirmationInfo = driver.findElement(By.xpath("//div[@class='success-message w-form-done']"));
        Assert.assertTrue(ConfirmationInfo.isDisplayed());
    }



}
