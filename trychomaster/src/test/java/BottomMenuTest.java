import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BottomMenuTest extends TestBase {

    //this class covers Test Case "Bottom Menu sub pages" (TC_3)

    public BottomMenuTest(){super();}

    //initialization of setup from TestBase class
   @BeforeMethod
   public void setUp() {initialization();}


    @AfterMethod
    public void testDone (){
        driver.close();
        driver.quit();
    }

    //checking each subpage using assertion
    //correct data is stored in testdata.properties
    @Test (priority = 1)
    public void Jonizatory (){
        WebElement JonizatoryButton = driver.findElement(By.xpath("//*[contains(text(), 'Jonizatory')][@class='footer-link']"));
        JonizatoryButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctJonizatoryPageTitle"));
    }


    @Test (priority = 2)
    public void Produkty (){
        WebElement ProduktyButton = driver.findElement(By.xpath("//*[contains(text(), 'Produkty')][@class='footer-link']"));
        ProduktyButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctProduktyPageTitle"));
    }

    @Test (priority = 3)
    public void Ebook () {
        WebElement EbookButton = driver.findElement(By.xpath("//*[contains(text(), 'E-Book')][@class='footer-link']"));
        EbookButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctEbookPageTitle"));
    }

    @Test (priority = 4)
    public void Onas() {
        WebElement OnasButton = driver.findElement(By.xpath("//*[contains(text(), 'O nas')][@class='footer-link']"));
        OnasButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctOnasPageTitle"));
    }

    @Test (priority = 5)
    public void FAQ () {
        WebElement FAQButton = driver.findElement(By.xpath("//*[contains(text(), 'FAQ')][@class='footer-link']"));
        FAQButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctFAQPageTitle"));
}

    @Test (priority = 6)
    public void Kontakt () {
        WebElement KontaktButton = driver.findElement(By.xpath("//*[contains(text(), 'Kontakt')][@class='footer-link']"));
        KontaktButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctKontaktPageTitle"));
    }

    @Test (priority = 7)
    public void TrychologiaMedyczna () {
        WebElement TrychologiaMedycznaButton = driver.findElement(By.xpath("//*[contains(text(), 'Trychologia medyczna')][@class='footer-link']"));
        TrychologiaMedycznaButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctTrychologiaMedycznaPageTitle"));
    }

    @Test (priority = 8)
    public void TrychologiaKosmetyczna () {
        WebElement TrychologiaKosmetycznaButton = driver.findElement(By.xpath("//*[contains(text(), 'Trychologia kosmetyczna')][@class='footer-link']"));
        TrychologiaKosmetycznaButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctTrychologiaKosmetycznaPageTitle"));
    }

    @Test (priority = 9)
    public void Cookies () {
        WebElement CookiesButton = driver.findElement(By.xpath("//*[contains(text(), 'Cookies')][@class='footer-link legal']"));
        CookiesButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctCookiesPageTitle"));
    }

    @Test (priority = 10)
    public void Regulamin () {
        WebElement RegulaminButton = driver.findElement(By.xpath("//*[contains(text(), 'Regulamin')][@class='footer-link legal']"));
        RegulaminButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctRegulaminPageTitle"));
    }

    @Test (priority = 11)
    public void RODO () {
        WebElement RODOButton = driver.findElement(By.xpath("//*[contains(text(), 'RODO')][@class='footer-link legal']"));
        RODOButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctRODOPageTitle"));
    }
}
