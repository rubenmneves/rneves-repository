package StepDefinitions;

import Pages.HomePage;
import Pages.SearchPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.xpath.operations.String;

import static Common.Navigator.isOnPage;

/**
 * Created by rneves on 1/21/16.
 */
public class HomeSteps {
    @Given("^that I go to Springer homepage$")
    public void that_I_go_to_Springer_homepage() throws Throwable {
        HomePage.gotoHome();
    }

    @When("^I input the query \"([^\"]*)\" on the search bar$")
    public void I_input_the_query_on_the_search_bar(String query) throws Throwable {
        HomePage.query_searcher(query);
    }

    @Then("^I press the button search$")
    public void iPressTheButtonSearch() throws Throwable {
        HomePage.press_search();
    }

    @Then("^I should get directed to the \"([^\"]*)\" page$")
    public void I_should_get_directed_to_the_page(String page) throws Throwable {
        isOnPage(page);
    }


    @And("^I should see a \"([^\"]*)\"$")
    public void iShouldSeeA(String element) throws Throwable {
        SearchPage.findElement(element);
    }


    @And("^I should see some amount of results$")
    public void iShouldSeeSomeAmountOfResults() throws Throwable {
        SearchPage.amountCheck(false);
    }

    @And("^I should see 0 results$")
    public void iShouldSeeResults() throws Throwable {
        SearchPage.amountCheck(true);
    }
}
