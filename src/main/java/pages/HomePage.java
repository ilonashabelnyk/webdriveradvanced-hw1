package pages;

import com.codeborne.selenide.Selenide;

public class HomePage extends BasePage {
    private static final String bookDepository_URL = "https://www.bookdepository.com/";

    public void openBookdepository() {
       Selenide.open(bookDepository_URL);
    }
}