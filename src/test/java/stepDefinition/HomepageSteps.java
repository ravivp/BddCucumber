package stepDefinition;

import Pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.DriverFactory;

import java.util.List;

public class HomepageSteps {


    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("User on Home page")
    public void user_on_home_page() {

        Assert.assertEquals("Your Store", homePage.getTittle());

    }


    @Then("Verify headers components on home page")
    public void verify_headers_components_on_home_page(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,

        List<String> headerTextData=dataTable.asList();

       // Assert.assertEquals(actual,expected);

        System.out.println(headerTextData);

        Assert.assertEquals(homePage.headerListText(),headerTextData);

    }
    @Then("Verify various feature components")
    public void verify_various_feature_components() {

        Assert.assertTrue(homePage.verifyFeaturesComponents());
    }

}
