package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static String strChromeDriverPath = "Drivers/ChromeDriver/chromedriver84";
    private static String strFireFoxDriverPath = "Drivers/FireFoxDriver/geckodriver";

    private static File cDriverPath = new File(strChromeDriverPath);
    private static File fDriverPath = new File(strFireFoxDriverPath);

    private static WebDriver genericDriver;

    public static WebDriver getDriver(int driver){
        switch (driver){
            case 1:
                if ( genericDriver == null){
                    System.setProperty("webdriver.chrome.driver", cDriverPath.getAbsolutePath());
                    genericDriver = new ChromeDriver(chromeOptions());
                    genericDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
                return genericDriver;
            case 2:
                if (genericDriver == null){
                    System.setProperty("webdriver.gecko.driver", fDriverPath.getAbsolutePath());
                    genericDriver = new FirefoxDriver(firefoxOptions());
                    genericDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
                return genericDriver;
            default:
                throw new IllegalStateException("Unexpected value: " + driver);
        }
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
//        options.addArguments("--headless");
        options.addArguments("incognito");
        return options;
    }

    private static FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
//        options.addArguments("--headless");
        options.addArguments("incognito");
        return options;
    }


}
