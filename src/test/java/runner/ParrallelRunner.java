package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ParrallelPropertyReader;

import java.util.Properties;


@CucumberOptions(
 features = "src/test/java/features/",
        // glue = {"stepDefinition","appHooks"},
      glue = {"stepDefinition"},
         plugin = {"pretty",
         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
         },
         monochrome = true,
         publish = true,

         dryRun = false
)
public class ParrallelRunner extends AbstractTestNGCucumberTests {


//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//
//        return super.scenarios();
//
//    }

    private  DriverFactory driverFactory;
    private WebDriver driver;
//    private ConfigReader configReader;
//    public Properties properties;

    @BeforeMethod
    @Parameters("browserType")
    public void beforeClass(@Optional String browserType){

        ParrallelPropertyReader.initializePropertyFile();

        ParrallelPropertyReader.properties.get().setProperty("browser",browserType);
        driverFactory =new DriverFactory();
        driver= driverFactory.initDriver( ParrallelPropertyReader.properties.get().getProperty("browser"));


    }

    @AfterMethod
    public   void afterClass(){
        driver.close();

    }

}
