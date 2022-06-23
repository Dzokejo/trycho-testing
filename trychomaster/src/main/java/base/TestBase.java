package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// this is Test Base class that will be used across all tests in order to not duplicate code for each test


public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties config;
    public static Properties testdata;


    //setting up 2 properties files that will contain variables for configuration and data, that all tests will be referring to
    public TestBase() {
        try {
            config = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/config/config.properties");
            config.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testdata = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/java/testdata/testdata.properties");
            testdata.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method with starting setup and enabling easy switch between 4 different browsers
    public static void initialization() {

        //creating string variables that are defined in config file
        String url = config.getProperty("URL");
        String browser = config.getProperty("browser");
        String pageLoadTimeout = config.getProperty("pageLoadTimeout");
        String windowsMaximize = config.getProperty("windowsMaximize");
        String deleteAllCookies = config.getProperty("deleteAllCookies");
        String waitTimeout = config.getProperty("waitTimeout");


        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +
                        "/src/main/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);

                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
                        "/src/main/resources/geckodriver.exe");

                driver = new FirefoxDriver();

                break;
            case "msedge":
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
                        "/src/main/resources/msedgedriver.exe");


                driver = new EdgeDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") +
                        "/src/main/resources/operadriver.exe");

                driver = new OperaDriver();
                break;

            default:
                throw new IllegalArgumentException("Nierozpoznano typu przeglądarki internetowej." +
                        "Obsługiwane następujące opcje: chrome, firefox, ie");
        }


        if (deleteAllCookies.equalsIgnoreCase("true")) {
            driver.manage().deleteAllCookies();
        }
        if (windowsMaximize.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pageLoadTimeout), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Integer.parseInt(waitTimeout));

        driver.get(url);

    }



}
