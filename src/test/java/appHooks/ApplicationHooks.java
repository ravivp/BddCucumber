package appHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import utilities.ConfigReader;
import utilities.DriverFactory;

import java.util.Properties;

public class ApplicationHooks {

  private DriverFactory driverFactory;
  private WebDriver driver;
  private ConfigReader configReader;
   public    Properties properties;


  // these are global hooks , where hooks has pre- and post-condition for each scenario
  @Before(order = 0)
  public void getProperty(){

      configReader=new ConfigReader();
      properties=configReader.initProp();

  }

  @Before(order = 1)
  public void launchBrowsers(){

   String browserName= properties.getProperty("browser");
    driverFactory =new DriverFactory();
   driver= driverFactory.initDriver(browserName);


  }

  @After(order = 0)
  public void quitBrowser(){


    driver.close();

//    if (driver!=null){
//      driver.close();
//      driver.quit();
//    }


  }

  @After(order = 1)
  public void tearDown(Scenario scenario){

    if(scenario.isFailed()){

      String screenshotName=scenario.getName().replaceAll(" ", "_");
      byte[] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);

      scenario.attach(sourcePath, "image/png", screenshotName);

    }
  }

  //These are local hooks where they will execute before and after to belong to the sanity-test group
//   @Before("@sanityTesting")
//    public void validated(){
//
//   }
//
//    @After("@sanityTesting")
//    public void afterValidated(){
//
//    }


  //
//  @BeforeTest()
//  @Parameters("browser")
//  public void launchBrowsers(String browser){
//
//    configReader=new ConfigReader();
//    properties=configReader.initProp();
//    driverFactory =new DriverFactory();
//    driver= driverFactory.initDriver(browser);
//
//  }
//
//
//
//  @AfterTest()
//
//  public void tearDown(Scenario scenario) {
//
//    if (scenario.isFailed()) {
//
//      String screenshotName = scenario.getName().replaceAll(" ", "_");
//      byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//      scenario.attach(sourcePath, "image/png", screenshotName);
//      driver.close();
//
//
//    }
//  }

}
