package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchAttributesPage extends BasePage {
    private static final String searchInput = "searchTerm";
    private static final String searchBtn = "//form[@id='book-search-form']//button[.='Search']";
    private static final String searchResults = "//*[contains(@class, 'book-item')]";
    private static final int emptySearchResults = 0;
    private static final String expectedRedirectURLSearchResults = "https://www.bookdepository.com/search?searchTerm=Thinking+in+Java&search=Find+book";
    private static final String booksTitles = "//*[@class='title']";
    private static final String priceRangeDropDown = "//select[@id='filterPrice']";
    private static final String availabilityDropDown = "//select[@id='filterAvailability']";
    private static final String languageDropDown = "//select[@id='filterLang']";
    private static final String formatDropDown = "//select[@id='filterFormat']";
    private static final String refineResultsBtn = "//div[@class='form-group padded-btn-wrap']//*[@class='btn btn-primary']";
    private static final int searchResultsAfterAppliedFilters = 4;
    private static final String addToBasketBtnThinkingInJavaBook = "//a[@href='/basket/addisbn/isbn13/9781492072508']";

    public WebElement findSearchInput() {
        return findElement(By.name(searchInput));
    }

    public void clickOnSearchBtn() {
        findElement(By.xpath(searchBtn)).click();
    }

    public int countSearchResults() {
        List<WebElement> resultsNumber = findElements(By.xpath(searchResults));
        return resultsNumber.size();
    }

    public void performSearch(String searchTerm) {
        Actions builder = new Actions(DriverManager.getDriver());
        Action seriesOfActions = builder
                .moveToElement(findSearchInput())
                .click()
                .sendKeys(searchTerm + Keys.ENTER)
                .build();
        seriesOfActions.perform();
    }

    public static String getExpectedRedirectURLSearchResults() {
        return expectedRedirectURLSearchResults;
    }

    public String getSearchResultsPage() {
        return DriverManager.getDriver().getCurrentUrl();
    }

    public List<String> getBookTitles() {
        List<String> bookTitlesList = new ArrayList<>();
        List<WebElement> bookTitles = findElements(By.xpath(booksTitles));
        for (int i = 0; i < bookTitles.size(); i++) {
            bookTitlesList.add(bookTitles.get(i).getText());
        }
        return bookTitlesList;
    }

    public boolean checkBookByTitle(List<String> books) {
        return getBookTitles().containsAll(books);
    }


    public void selectPriceRange(String priceRangeStr) {
        Select priceRange = new Select(findElement(By.xpath(priceRangeDropDown)));
        priceRange.selectByValue(priceRangeStr);
    }

    public void selectAvailability(String availabilityStr) {
        Select priceRange = new Select(findElement(By.xpath(availabilityDropDown)));
        priceRange.selectByValue(availabilityStr);
    }

    public void selectLanguage(String languageStr) {
        Select priceRange = new Select(findElement(By.xpath(languageDropDown)));
        priceRange.selectByValue(languageStr);
    }

    public void selectFormat(String formatStr) {
        Select priceRange = new Select(findElement(By.xpath(formatDropDown)));
        priceRange.selectByValue(formatStr);
    }

    public WebElement findRefineResultsBtn() {
        return findElement(By.xpath(refineResultsBtn));
    }

    public void clickOnRefineResults() {
        findRefineResultsBtn().click();
    }

    public static int getSearchResultsAfterAppliedFilters() {
        return searchResultsAfterAppliedFilters;
    }

    public void clickOnAddToBasketBtnThinkingInJavaBook() {
        findElement(By.xpath(addToBasketBtnThinkingInJavaBook)).click();
    }
}