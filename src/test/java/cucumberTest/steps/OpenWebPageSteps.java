package cucumberTest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class OpenWebPageSteps {
    private HomePage homePage = new HomePage();

    @Given("Bookdepository website is opened on the main page")
    public void openBookdepositoryWebsite() {
        homePage.openBookdepository();
    }

    @Then("user is redirected into proper Home page")
    public void verifyHomePage() {
        Assert.assertTrue("Home page is not opened!", homePage.isHomePageContentIsDisplayed());
    }
}