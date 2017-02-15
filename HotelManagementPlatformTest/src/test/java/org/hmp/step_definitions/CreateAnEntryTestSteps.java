package org.hmp.step_definitions;

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
public class CreateAnEntryTestSteps {

    private final WorldHelper helper;
    //private HomePage homePage;
    private DataEntryPage dataEntryPage;

    public CreateAnEntryTestSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I have successfully signed in with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iHaveSuccessfullySignedInWithAnd(String username, String password) throws Throwable {
        dataEntryPage = helper.getBasePage().loadHomePage().goToDataEntryPage(username, password);
    }

    @When("^I enter the following customer details: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and click on create button$")
    public void iEnterTheFollowingCustomerDetailsAndClickOnCreateButton(String hotelName, String address, String owner,
                                                                        String phoneNumber, String email) throws Throwable {

        dataEntryPage = helper.getDataEntryPage().populateEntryDetails(hotelName, address, owner, phoneNumber, email);
    }

    @Then("^I should see a record containing the name of the owner \"([^\"]*)\"$")
    public void iShouldSeeARecordContainingTheNameOfTheOwner(String name) throws Throwable {
        assertTrue("No such entry exists", dataEntryPage.validateEntry(name.toLowerCase()));
    }
}
