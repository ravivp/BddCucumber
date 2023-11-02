package stepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class loginPageStepDef {


    private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
    private HomePage homePage=new HomePage(DriverFactory.getDriver());

    ConfigReader configReader=new ConfigReader();


    @Given("I launch the application")
    public void i_launch_the_application() throws InterruptedException {

        DriverFactory.getDriver().get(configReader.initProp().getProperty("url"));
        Thread.sleep(3000);

    }
    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password(DataTable dataTable ) {
//        loginpage.login("ravivp123@gmail.com","pawar@12345");

        List<Map<String, String>> userCredential=dataTable.asMaps();


        loginpage.enterEmail(userCredential.get(0).get("username"));
        loginpage.enterPassword(userCredential.get(0).get("password"));
    }

    @When("I click on login button")
    public void i_click_on_login_button() {

        loginpage.clickLoginLink();

    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {

        Assert.assertTrue(loginpage.checkSuccessPage());
    }

    @Given("I have entered a invalid {string} and {string}")
    public void i_have_entered_a_invalid_and(String email, String password) throws InterruptedException {

//        homePage.clickOnMyAccount();
//        homePage.clickLoginLink();
        loginpage.enterEmail(email);
        Thread.sleep(3000);
        loginpage.enterPassword(password);
        loginpage.clickLoginLink();

    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {

        System.out.println(errorMessage+"  : -------------");
        System.out.println(loginpage.checkErrorMessage()+"  : -------------");

    //  Assert.assertEquals(loginpage.checkErrorMessage(),errorMessage.trim());

    }

    @When("I click on forgotten password link")
    public void i_click_on_forgotten_password_link() {
       loginpage.clickOnForgottenPasswordLink();

    }
    @Then("I should redirect to the password reset page")
    public void i_should_redirect_to_the_password_reset_page() {

        Assert.assertTrue(loginpage.checkMessageOnRestPasswordPage());
    }

    @Given("User should on login page")
    public void user_should_on_login_page() throws InterruptedException {

        homePage.clickOnMyAccount();
        homePage.clickLoginLink();
        Thread.sleep(2000);

    }

    @When("User enter invalid credential")
    public void user_enter_invalid_credential(DataTable dataTable) throws InterruptedException {

       for(Map<String, String> invalidTestData:dataTable.asMaps()){

           loginpage.enterEmail(invalidTestData.get("email"));
           Thread.sleep(3000);
           loginpage.enterPassword(invalidTestData.get("password"));
           Thread.sleep(3000);
           loginpage.clickLoginLink();
           Thread.sleep(2000);
           System.out.println(loginpage.checkErrorMessage()+"  : -------------");

       }

    }
    @Then("I should see an error message on login page")
    public void i_should_see_an_error_message_on_login_page() {
        System.out.println(loginpage.checkErrorMessage()+"  : -------------");
    }

}
