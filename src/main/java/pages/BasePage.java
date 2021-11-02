//package pages;
//
//import driver.DriverManager;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.List;
//
//public class BasePage {
//    public BasePage() {
//        PageFactory.initElements(DriverManager.setUpDriver(), this);
//    }
//
//    public WebElement findElement(By by) {
//        return DriverManager.setUpDriver().findElement(by);
//    }
//
//    public List<WebElement> findElements(By by) {
//        return DriverManager.getDriver().findElements(by);
//    }
//
//    public boolean isElementDisplayed(By by) {
//        return !findElements(by).isEmpty();
//    }
//
//    public boolean isCurrentlyVisible(By by) {
//        try {
//            WebElement element = findElement(by);
//            return (element != null) && (element.isDisplayed());
//        } catch (ElementNotVisibleException | NoSuchElementException | StaleElementReferenceException e) {
//            return false;
//        }
//    }
//}