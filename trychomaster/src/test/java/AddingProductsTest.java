import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AddingProductsTest extends TestBase {

    //This class covers Test Case 'Adding products to cart' (TC_7)

    public AddingProductsTest (){super();}

    //initialization of setup from TestBase class
    @BeforeClass
    public void setUp(){initialization();}

    @AfterClass
    public  void testDone(){
        driver.close();
        driver.quit();
    }

    //setting up Screenshot method in order to take picture of the cart, after each new addition of products to it
    public void takeScreenShot(int TestNumber) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + TestNumber + "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    //getting to Shop sub page
    @Test (priority = 1)
    public void Sklep (){
        WebElement SklepButton = driver.findElement(By.xpath("//*[contains(text(), 'Sklep')][@class='nav-link w-nav-link']"));
        SklepButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctSklepPageTitle"));
    }

    //adding Ebook to the cart
    @Test (priority = 2)
    public void EbookAdd () throws InterruptedException {
        WebElement EbookAddInput = driver.findElement(By.xpath("//*[@class='heading-30']//following::div[1]//input[@name='commerce-add-to-cart-quantity-input']"));
        EbookAddInput.clear();
        EbookAddInput.sendKeys("4");
        WebElement EbookAddToCart = driver.findElement(By.xpath("//*[@class='heading-30']//following::div[1]//input[@value='Dodaj do koszyka']"));
        EbookAddToCart.click();
        Thread.sleep(2000);
        takeScreenShot(1);

    }
    //adding Produkty to the cart
    //in the same time checking if only selected product is added to the cart even when all remaining products also where given value to input
    @Test (priority = 3)
    public void ProduktyAdd () throws InterruptedException {
        driver.navigate().refresh();
        String allOtherProductsInputsXpath = "//div[@data-w-tab='Produktys']//div[@role='listitem']//input[@name='commerce-add-to-cart-quantity-input']";
        List<WebElement> allOtherProductInputs = driver.findElements(By.xpath(allOtherProductsInputsXpath));
        for (WebElement productInput : allOtherProductInputs) {
            productInput.clear();
            productInput.sendKeys("5");
        }
        WebElement ProduktyAddToCart = driver.findElement(By.xpath("//div[@data-w-tab='Produktys']//div[@role='listitem']//following::div[11]//div[@class='add-to-cart']//input[@type='submit']"));
        ProduktyAddToCart.click();
        Thread.sleep(2000);
        takeScreenShot(2);
    }

    //adding Jonizatory to the cart
    @Test (priority = 4)
    public void JonizatoryAdd () throws InterruptedException {
        driver.navigate().refresh();
        WebElement JonizatoryTab = driver.findElement(By.xpath("//a[@data-w-tab='Jonizator']"));
        JonizatoryTab.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content-section']//div[@data-current='Produktys']//*[@class='w-tab-content']//div[@data-w-tab='Jonizator']//div[@role='listitem']//input[@name='commerce-add-to-cart-quantity-input']")));
        WebElement JonizatoryAddInput = driver.findElement(By.xpath("//*[@class='content-section']//div[@data-current='Produktys']//*[@class='w-tab-content']//div[@data-w-tab='Jonizator']//div[@role='listitem']//input[@name='commerce-add-to-cart-quantity-input']"));
        JonizatoryAddInput.clear();
        JonizatoryAddInput.sendKeys("3");
        WebElement JonizatoryAddToCart = driver.findElement(By.xpath("//*[@class='content-section']//div[@data-current='Produktys']//*[@class='w-tab-content']//div[@data-w-tab='Jonizator']//div[@role='listitem']//input[@type='submit']"));
        JonizatoryAddToCart.click();
        Thread.sleep(2000);
        takeScreenShot(3);

    }
}
