import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BottomMenuTest_Multisession extends TestBase {

    /*this is optional version that covers TC_3 and it's able to carry all tests at the same time instead of one by one
    approach used in the BottomMenuTest class */

    public BottomMenuTest_Multisession(){super();}


    @AfterTest
    public void testDone (){
        driver.quit();
    }

    // tests can be launched through Multisession.xml

    @Test (priority = 1)
    public void Jonizatory (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement JonizatoryButton = driver.findElement(By.xpath("//*[contains(text(), 'Jonizatory')][@class='footer-link']"));
        JonizatoryButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctJonizatoryPageTitle"));

        driver.close();
    }


    @Test (priority = 2)
    public void Produkty (){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement ProduktyButton = driver.findElement(By.xpath("//*[contains(text(), 'Produkty')][@class='footer-link']"));
        ProduktyButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctProduktyPageTitle"));

        driver.close();
    }

    @Test (priority = 3)
    public void Ebook () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement EbookButton = driver.findElement(By.xpath("//*[contains(text(), 'E-Book')][@class='footer-link']"));
        EbookButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctEbookPageTitle"));

        driver.close();
    }

    @Test (priority = 4)
    public void Onas() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement OnasButton = driver.findElement(By.xpath("//*[contains(text(), 'O nas')][@class='footer-link']"));
        OnasButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctOnasPageTitle"));

        driver.close();
    }

    @Test (priority = 5)
    public void FAQ () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement FAQButton = driver.findElement(By.xpath("//*[contains(text(), 'FAQ')][@class='footer-link']"));
        FAQButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctFAQPageTitle"));

        driver.close();
}

    @Test (priority = 6)
    public void Kontakt () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement KontaktButton = driver.findElement(By.xpath("//*[contains(text(), 'Kontakt')][@class='footer-link']"));
        KontaktButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctKontaktPageTitle"));

        driver.close();
    }

    @Test (priority = 7)
    public void TrychologiaMedyczna () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement TrychologiaMedycznaButton = driver.findElement(By.xpath("//*[contains(text(), 'Trychologia medyczna')][@class='footer-link']"));
        TrychologiaMedycznaButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctTrychologiaMedycznaPageTitle"));

        driver.close();
    }

    @Test (priority = 8)
    public void TrychologiaKosmetyczna () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement TrychologiaKosmetycznaButton = driver.findElement(By.xpath("//*[contains(text(), 'Trychologia kosmetyczna')][@class='footer-link']"));
        TrychologiaKosmetycznaButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctTrychologiaKosmetycznaPageTitle"));

        driver.close();
    }

    @Test (priority = 9)
    public void Cookies () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement CookiesButton = driver.findElement(By.xpath("//*[contains(text(), 'Cookies')][@class='footer-link legal']"));
        CookiesButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctCookiesPageTitle"));

        driver.close();
    }

    @Test (priority = 10)
    public void Regulamin () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement RegulaminButton = driver.findElement(By.xpath("//*[contains(text(), 'Regulamin')][@class='footer-link legal']"));
        RegulaminButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctRegulaminPageTitle"));

        driver.close();
    }

    @Test (priority = 11)
    public void RODO () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(config.getProperty("URL"));
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("waitTimeout")));

        WebElement RODOButton = driver.findElement(By.xpath("//*[contains(text(), 'RODO')][@class='footer-link legal']"));
        RODOButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctRODOPageTitle"));

        driver.close();
    }
}
