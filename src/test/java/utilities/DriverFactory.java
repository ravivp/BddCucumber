package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverFactory {


    public WebDriver driver;

    public static  FirefoxOptions firefoxOptions;
    public static  ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
    

    public  WebDriver  initDriver(String browserName){

        System.out.println("Browser value is: "+browserName);

        if(browserName.equals("chrome")){

            ChromeOptions option= new ChromeOptions();
            option.addArguments("incognito");
            //  option.setHeadless(true);
            option.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().clearDriverCache().setup();
            //driver=new ChromeDriver(option);

            tlDriver.set(new ChromeDriver(option));

        } else if (browserName.equals("firefox")) {


            firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("incognito");
           // firefoxOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().clearDriverCache().setup();
          //  driver=new FirefoxDriver(firefoxOptions);

//            FirefoxProfile profile = new FirefoxProfile();
//            profile.setPreference("network.proxy.no_proxies_on", "localhost");
//            profile.setPreference("javascript.enabled", true);
//
//            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//            capabilities.setCapability("marionette", true);
//            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//
//            FirefoxOptions options = new FirefoxOptions();
//            options.merge(capabilities);
//            options.setLogLevel(Level.FINEST);
//            options.addPreference("browser.link.open_newwindow", 3);
//            options.addPreference("browser.link.open_newwindow.restriction", 0);
           tlDriver.set(new FirefoxDriver(firefoxOptions));


        } else if (browserName.equals("edge")) {


            WebDriverManager.edgedriver().clearDriverCache().setup();

            tlDriver.set(new EdgeDriver());

        } else {

            System.out.println("Please pass correct browser value: " +browserName);
        }



        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(TimeOut.pageLoadTimeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(TimeOut.elementWait, TimeUnit.SECONDS);
        return getDriver();
        //return  driver;
    }

    public  static synchronized WebDriver getDriver(){

        return tlDriver.get();
    }
}
