package cucumberTest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchAttributesPage;

public class SearchPlaceholderSteps {
    private SearchAttributesPage searchAttributesPage = new SearchAttributesPage();

    @When("search input field is found")
    public void findSearchInputField() {
        searchAttributesPage.findSearchInput();
    }

    @Then("there is placeholder {string}")
    public void verifyPlaceholder(String placeholder) {
        Assert.assertEquals("Incorrect placeholder for search input field.", placeholder, searchAttributesPage.getSearchPlaceholder());
    }
}