package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);


    }

    @FindBy(xpath = "//ul[@class='list-inline']//span[contains(@class,'hidden-xs')]")
    private List<WebElement> headerList;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li/child::a")
    private List<WebElement> subHeaders;

    @FindBy(xpath = "//div[@class='row']//div[contains(@class,'product-layout')]")
    private List<WebElement> features;
    @FindBy(xpath = "//a[@title='My Account']")
    private  WebElement myAccountLink;
    public boolean verifyHeaderList() throws InterruptedException {


      //  headerList.stream().forEach(element->element.getText());
        Thread.sleep(3000);
        System.out.println(headerList.stream().map(element->element.getText()).collect(Collectors.toList()));

        Thread.sleep(3000);
        boolean isAllTrue =  headerList.stream().map(element->element.isDisplayed())
              .allMatch(val->val==true);
      //Arrays.stream(myArray).allMatch(Boolean::valueOf);
          //    .collect(Collectors.toList()).contains(false);


        return isAllTrue;
    }
    public List<String> headerListText(){

        List<String> headerText=headerList.stream().map(item->item.getText()).collect(Collectors.toList());
        System.out.println(headerText);
        return  headerText;
    }

    public void clickLoginLink() {
         loginLink.click();
    }


    public boolean verifySubHeaders() throws InterruptedException {

        Thread.sleep(3000);
        System.out.println(subHeaders.stream().map(element->element.getText()));

        Thread.sleep(3000);
      boolean isAllTrue=  subHeaders.stream().map(element->element.isDisplayed()).allMatch(val->val==true);

      return  isAllTrue;
    }



    public boolean verifyFeaturesComponents() {
        return features.stream().map(element->element.isDisplayed()).allMatch(value->value==true);
    }

    public String getTittle(){

        return driver.getTitle();
    }

    public void clickOnMyAccount(){

        myAccountLink.click();
    }
}
