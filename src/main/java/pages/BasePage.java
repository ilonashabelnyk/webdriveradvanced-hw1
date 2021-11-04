package pages;

import com.codeborne.selenide.*;

import org.openqa.selenium.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {

    public SelenideElement findElement(By by) {
        return $(by);
    }

    public ElementsCollection findElements(By by) {
        return $$(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }

    public boolean isCurrentlyVisible(By by) {
        try {
            SelenideElement element = findElement(by);
            return (element != null) && (element.isDisplayed());
        } catch (ElementNotVisibleException | NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}