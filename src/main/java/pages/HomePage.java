package pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private static final String bookDepository_URL = "https://www.bookdepository.com/";

    public void openBookdepository() {
        DriverManager.getDriver().get(bookDepository_URL);
    }
}