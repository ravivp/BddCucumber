package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage   {

   private WebDriver driver;


    public LoginPage(WebDriver driver){

         this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement inputEmailLocator;
    @FindBy(css = "input#input-password")
    private WebElement inputPasswordLocator;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginCustomerLink;

    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement  successMessage;

    @FindBy(css = "div.alert.alert-danger.alert-dismissible")

    private WebElement errorMassage;
    //div[text()=' Warning: No match for E-Mail Address and/or Password.']"
    @FindBy(xpath = "//div[@class='form-group']//a[text()='Forgotten Password']")
    //div[@class='form-group']//a[text()='Forgotten Password']
  //  (//a[text()='Forgotten Password'])[1]
    private WebElement  forgottenPasswordLink;
    @FindBy(xpath = "//h1[text()='Forgot Your Password?']")
    private WebElement  messageOnRestPasswordPage;




    public void enterEmail(String email){

      //  WebElement emailInput=driver.findElement(inputEmailLocator);
       // emailInput.sendKeys(email);
        inputEmailLocator.clear();
        inputEmailLocator.sendKeys(email);
    }

    public void enterPassword(String password){

//        WebElement emailInput=driver.findElement(inputPasswordLoctor);
//        emailInput.sendKeys(password);

        inputPasswordLocator.sendKeys(password);
    }


    public void clickLoginLink(){

//        WebElement emailInput=driver.findElement(loginCustomerLink);
//        emailInput.click();

        //loginCustomerLink.click();

        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", loginCustomerLink);
    }
   public boolean checkLoginButton(){

       return loginCustomerLink.isDisplayed();
   }
    public boolean checkForgottenPasswordLink(){

      return forgottenPasswordLink.isDisplayed();

    }

    public void clickOnForgottenPasswordLink(){

        // driver.findElement(forgottenPasswordLink).click();

        forgottenPasswordLink.click();

    }
    public String checkErrorMessage(){

       // return driver.findElement(errorMassage).getText().trim();
        return  errorMassage.getText().trim();
    }
    public void login(String email, String password){

        enterEmail(email);
        enterPassword(password);
        clickLoginLink();


    }
    public boolean checkSuccessPage(){

      // return driver.findElement(successMessage).isDisplayed();
        return  successMessage.isDisplayed();
    }

    public boolean checkMessageOnRestPasswordPage(){

      //  return  driver.findElement(messageOnRestPasswordPage).isDisplayed();

        return  messageOnRestPasswordPage.isDisplayed();
    }
}
