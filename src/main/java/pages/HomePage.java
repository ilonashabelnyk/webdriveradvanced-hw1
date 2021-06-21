package pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final String bookDepository_URL = "https://www.bookdepository.com/";
    private static final String signInJoinBtn = "div.user-nav-wrap  i.icon-user";
    private static final String homePageContent = "//*[@class='main-content no-borders home-page']";

    public void openBookdepository() {
        DriverManager.getDriver().get(bookDepository_URL);
    }

    public void clickOnSignInJoinBtn() {
        findElement(By.cssSelector(signInJoinBtn)).click();
    }

    public boolean isHomePageContentIsDisplayed() {
        return isElementDisplayed(By.xpath(homePageContent));
    }
}