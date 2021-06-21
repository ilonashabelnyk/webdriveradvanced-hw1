package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchAttributesPage extends BasePage {
    private static final String searchInput = "searchTerm";
    private static final String searchBtn = "//form[@id='book-search-form']//button[.='Search']";
    private static final String searchResults = "//*[contains(@class, 'book-item')]";
    private static final int emptySearchResults = 0;

    public WebElement findSearchInput() {
        return findElement(By.name(searchInput));
    }

    public String getSearchPlaceholder() {
        return findSearchInput().getAttribute("placeholder");
    }

    public void enterSearchTerm() {
        findSearchInput().sendKeys("Zaratustra");
    }

    public void clickOnSearchBtn() {
        findElement(By.xpath(searchBtn)).click();
    }

    public static int getEmptySearchResults() {
        return emptySearchResults;
    }

    public int countSearchResults() {
        List<WebElement> resultsNumber = findElements(By.xpath(searchResults));
        return resultsNumber.size();
    }
}