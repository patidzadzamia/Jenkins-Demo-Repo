package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebdriverUtils {


    //SINGLETON WEBDRIVER

    private static WebDriver driver;

    private WebdriverUtils(){

    }


    public static WebDriver getWebDriver(){
        if(driver==null){
            String browserType = LocalConfigUtils.getProperty("browser");
            System.out.println("broswer::: " +browserType);

            switch (browserType.toLowerCase()){
                case "firefox" :
                    System.setProperty("webdriver.gecko.driver","C:\\Users\\Pati\\Desktop\\Drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pati\\Desktop\\Drivers\\chromedriver_win32\\chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
            }

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;

    }




    public static void closeWebDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }




}







































