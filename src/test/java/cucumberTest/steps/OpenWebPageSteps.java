package cucumberTest.steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import com.codeborne.selenide.Selenide;


public class OpenWebPageSteps {

    @Given("I open the {string} web page and the title is {string}")
    public void openWebPageVerifyTitle(String pageUrl, String expectedTitle) {
        Selenide.open(pageUrl);
        Assert.assertEquals("Incorrect page title!", expectedTitle, Selenide.title());
        Selenide.closeWindow();
    }
}