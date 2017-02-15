package org.hmp.step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hmp.page_objects.DataEntryPage;
import org.hmp.page_objects.HomePage;
import org.hmp.support.WorldHelper;

import static org.junit.Assert.assertTrue;

/**
 * Created by inet-tech on 14/02/17.
 */
public class LoginTestSteps {

    private final WorldHelper helper;
    private HomePage homePage;
    private DataEntryPage dataEntryPage;

    public LoginTestSteps(WorldHelper helper){
        this.helper = helper;
    }

    @Given("^I am on the Home page of the Hotel application$")
    public void iAmOnTheHomePageOfTheHotelApplication() throws Throwable {
        homePage = helper.getBasePage().loadHomePage();
    }

    @When("^I supply username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iSupplyUsernameAndPassword(String username, String password) throws Throwable {
        dataEntryPage = homePage.goToDataEntryPage(username, password);
    }

    @Then("^I should see a Logout \"([^\"]*)\"$")
    public void iShouldSeeALogout(String logout) throws Throwable {
        assertTrue("Sorry you have not successfully logged in", dataEntryPage.validateLogin(logout));
    }
}
