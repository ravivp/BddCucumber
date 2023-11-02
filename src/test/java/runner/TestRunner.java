package runner;


import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.util.Properties;


@CucumberOptions(
        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        // src/test/features
//        "json:target/cucumber-reports/cucumber.json",
//        "html:target/cucumber-reports/cucumberreport.html",
//src/test/java/stepDefinition/
        features = "src/test/java/features/",
      glue = {"stepDefinition","appHooks"},
//        glue = {"stepDefinition"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                 },
        monochrome = true,
        publish = true,

        dryRun = false,
        tags = "@smoke or @RegressionTesting"
       // tags="@Smoke or @Sanity or @Reg", or tags="@Smoke and @Sanity and @Reg"



)
public class TestRunner extends AbstractTestNGCucumberTests {

//    private DriverFactory driverFactory;
//    private WebDriver driver;
//    private ConfigReader configReader;
//    Properties properties;

    @Override
    @DataProvider(parallel = true)
    public  Object[][] scenarios(){
        return super.scenarios();
    }

//
//    @BeforeTest()
//    @Parameters("browser")
//    public void launchBrowsers(String browser){
//
//        configReader=new ConfigReader();
//        properties=configReader.initProp();
//        driverFactory =new DriverFactory();
//        driver= driverFactory.initDriver(browser);
//
//    }
//
//
//
//    @AfterTest()
//
//    public void tearDown(Scenario scenario) {
//
//        if (scenario.isFailed()) {
//
//            String screenshotName = scenario.getName().replaceAll(" ", "_");
//            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//            scenario.attach(sourcePath, "image/png", screenshotName);
//            driver.close();
//
//
//        }
//    }
}
