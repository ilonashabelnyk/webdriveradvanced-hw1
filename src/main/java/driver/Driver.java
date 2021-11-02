//package driver;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//
//import java.util.List;
//import java.util.Set;
//
//public class Driver implements WebDriver {
//
//    WebDriver driver;
//    String browserName;
//
//    public Driver(String browserName) {
//        this.browserName = browserName;
//
//        if (browserName.equalsIgnoreCase("chrome"))
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            this.driver = new ChromeDriver();
//
//        if (browserName.equalsIgnoreCase("firefox"))
//            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//            this.driver = new FirefoxDriver();
//
//        if (browserName.equalsIgnoreCase("ie"))
//            this.driver = new InternetExplorerDriver();
//
//    }
//
//    public Driver() {
//
//    }
//
//    public void close() {
//        this.driver.close();
//
//    }
//
//    public WebElement findElement(By arg0) {
//        return this.driver.findElement(arg0);
//    }
//
//    public List<WebElement> findElements(By arg0) {
//        return this.driver.findElements(arg0);
//    }
//
//    public void get(String arg0) {
//        this.driver.get(arg0);
//
//    }
//
//    public String getCurrentUrl() {
//        return this.driver.getCurrentUrl();
//    }
//
//    public String getPageSource() {
//        return this.driver.getPageSource();
//    }
//
//    public String getTitle() {
//        return this.driver.getTitle();
//    }
//
//    public String getWindowHandle() {
//        return this.driver.getWindowHandle();
//    }
//
//    public Set<String> getWindowHandles() {
//        return this.driver.getWindowHandles();
//    }
//
//    public Options manage() {
//        return this.driver.manage();
//    }
//
//    public Navigation navigate() {
//        return this.driver.navigate();
//    }
//
//    public void quit() {
//        this.driver.quit();
//    }
//
//    public TargetLocator switchTo() {
//        return this.driver.switchTo();
//    }
//}
