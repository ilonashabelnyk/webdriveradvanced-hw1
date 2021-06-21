package cucumberTest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchAttributesPage;

public class PerformSearchSteps {
    private SearchAttributesPage searchAttributesPage = new SearchAttributesPage();

    @When("search term is entered into search input field")
    public void enterSearchTerm() {
        searchAttributesPage.enterSearchTerm();
    }

    @And("Search button is clicked")
    public void clickOnSearchBtn() {
        searchAttributesPage.clickOnSearchBtn();
    }

    @Then("search is performed and search results are not empty")
    public void verifySearchResultsAreNotEmpty() {
        Assert.assertTrue("Search results are empty.", searchAttributesPage.countSearchResults() > searchAttributesPage.getEmptySearchResults());
    }
}