import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ProductPurchaseWebsitePaymentTest extends TestBase {

    //This class covers Test Case 'Product purchase - website payment' (TC_11)

    public ProductPurchaseWebsitePaymentTest(){super();}

    //initialization of setup from TestBase class
    @BeforeClass
    public void setUp (){initialization();}

    @AfterClass
    public void testDone(){
        driver.close();
        driver.quit();
    }

    //accessing store page
    @Test (priority = 1)
    public void Sklep (){
        WebElement SklepButton = driver.findElement(By.xpath("//*[contains(text(), 'Sklep')][@class='nav-link w-nav-link']"));
        SklepButton.click();
        Assert.assertEquals(driver.getTitle(), testdata.getProperty("correctSklepPageTitle"));
    }

    //adding some products to cart
    @Test (priority = 2)
    public void AddProduct() throws InterruptedException {
        WebElement AddProductInput = driver.findElement(By.xpath("//input[@name='commerce-add-to-cart-quantity-input']"));
        AddProductInput.clear();
        AddProductInput.sendKeys("3");
        WebElement AddToCart = driver.findElement(By.xpath("//input[@value='Dodaj do koszyka']"));
        AddToCart.click();
    }

    //continuing to payment
    @Test (priority = 3)
    public void PaymentProcessInitiation(){
        WebElement CartButton = driver.findElement(By.xpath("//*[@data-node-type='commerce-cart-open-link']"));
        CartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-node-type='cart-checkout-button']")));
        WebElement ContinueTransaction = driver.findElement(By.xpath("//*[@data-node-type='cart-checkout-button']"));
        ContinueTransaction.click();
    }

    //form fill in
    @Test (priority = 4)
    public void FillForm () throws InterruptedException {
        //Name and Surname fill in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w-commerce-commercelayoutmain']//form[@data-node-type='commerce-checkout-billing-address-wrapper']//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//input[@name='name']")));
        WebElement NameAndSurnameInput = driver.findElement(By.xpath("//div[@class='w-commerce-commercelayoutmain']//form[@data-node-type='commerce-checkout-billing-address-wrapper']//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//input[@name='name']"));
        NameAndSurnameInput.sendKeys(testdata.getProperty("CustomerNameAndSurname"));

        //using thread sleep just to facilitate observation on whats happening
        Thread.sleep(1000);

        //Street fill in
        WebElement StreetInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//input[@name='address_line1']"));
        StreetInput.sendKeys(testdata.getProperty("CustomerStreet"));

        Thread.sleep(1000);

        //Phone fill in
        WebElement PhoneNumber = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//input[@name='address_line2']"));
        PhoneNumber.sendKeys(testdata.getProperty("CustomerPhone"));

        Thread.sleep(1000);

        //City fill in
        WebElement CityInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//input[@class='w-commerce-commercecheckoutbillingcity input-field']"));
        CityInput.sendKeys(testdata.getProperty("CustomerCity"));

        Thread.sleep(1000);

        //Postal code fill in
        WebElement PostalCodeInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//input[@class='w-commerce-commercecheckoutbillingzippostalcode input-field']"));
        PostalCodeInput.sendKeys(testdata.getProperty("CustomerPostalCode"));

        Thread.sleep(1000);

        //Selecting country from drop down list
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//select[@class='w-commerce-commercecheckoutbillingcountryselector dropdown']")));
        Select CountryList = new Select(driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent form-block']//select[@class='w-commerce-commercecheckoutbillingcountryselector dropdown']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CountryList);
        CountryList.selectByValue("PL");

        Thread.sleep(1000);

        //email fill in
        WebElement EmailInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent']//input[@class='w-commerce-commercecheckoutemailinput input-field']"));
        EmailInput.sendKeys(testdata.getProperty("CustomerEmail"));

        Thread.sleep(1000);

        //Credit Card number fill in
        WebElement CreditCardInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent']//div[@data-wf-stripe-element-type='cardNumber']//div//iframe[@title='Bezpieczne pole wprowadzania numeru karty']"));
        CreditCardInput.sendKeys(testdata.getProperty("CustomerCreditCard"));

        Thread.sleep(1000);

        //Credit Card due time fill in
        WebElement CreditCardDueTimeInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent']//div[@class='w-commerce-commercecheckoutrow']//iframe[@title='Bezpieczne pole wprowadzania terminu ważności']"));
        CreditCardDueTimeInput.sendKeys(testdata.getProperty("CustomerCreditCardDueTime"));

        Thread.sleep(1000);

        //Credit Card CVC fill in
        WebElement CreditCardCVCInput = driver.findElement(By.xpath("//fieldset[@class='w-commerce-commercecheckoutblockcontent']//div[@class='w-commerce-commercecheckoutrow']//iframe[@title='Bezpieczne pole wprowadzania CVC']"));
        CreditCardCVCInput.sendKeys(testdata.getProperty("CustomerCreditCardCVC"));

        Thread.sleep(1000);
    }

    @Test (priority = 5)
    public void PaymentConfirmation(){
        //clicking confirm to end the process
        WebElement ConfirmTransactionButton = driver.findElement(By.xpath("//div[@class='order-detail']//a[@value='Zamawiam']"));
        ConfirmTransactionButton.click();

        //checking if proper confirmation is displayed
        //since I used fake data for payment, assert will fail
        WebElement TransactionInfo = driver.findElement(By.xpath("//div[@class='w-commerce-commercelayoutsidebar order-column']//div[@class='w-checkout-error-msg']"));
        Assert.assertEquals(TransactionInfo.getText(), "Your payment was successful");

    }



}
